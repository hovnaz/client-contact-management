package com.example.client.contact.management.core.service.impl;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.exception.ConflictException;
import com.example.client.contact.management.core.exception.ErrorMessage;
import com.example.client.contact.management.core.mapper.ClientMapper;
import com.example.client.contact.management.core.repository.ClientRepository;
import com.example.client.contact.management.core.service.ClientContactEmailService;
import com.example.client.contact.management.core.service.ClientContactPhoneNumberService;
import com.example.client.contact.management.core.service.ClientService;
import com.example.client.contact.management.core.support.ClientSupportService;
import com.example.client.contact.management.data.transfer.request.ClientRequest;
import com.example.client.contact.management.data.transfer.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientSupportService clientSupportService;
    private final ClientContactPhoneNumberService clientContactPhoneNumberService;
    private final ClientContactEmailService clientContactEmailService;
    private final ClientMapper clientMapper;

    @Override
    public ClientResponse addClient(ClientRequest clientRequest) {

        Optional<Client> clientOptional = clientRepository.findByEmailAndDeletionStatusDeletedFlagIsFalse(clientRequest.getEmail());
        if (clientOptional.isPresent()) {
            throw new ConflictException(ErrorMessage.CLIENT_EMAIL_ALREADY_EXIST);
        }
        Client client = clientMapper.toEntity(clientRequest);
        Client save = clientRepository.save(client);
        return clientMapper.toResponse(save);
    }

    @Override
    public ClientResponse findById(long id) {
        Client client = clientSupportService.getClientByIdOrThrow(id);
        return clientMapper.toResponse(client);
    }

    @Override
    public Page<ClientResponse> findAll(Pageable pageable) {
        Page<Client> clientPage = clientRepository.findAllByDeletionStatusDeletedFlagIsFalse(pageable);
        return clientPage.map(clientMapper::toResponse);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Client client = clientSupportService.getClientByIdOrThrow(id);
        if (!client.getDeletionStatus().isDeleted()) {
            clientContactPhoneNumberService.deleteAllByClientId(id);
            clientContactEmailService.deleteAllByClientId(id);
            client.getDeletionStatus().markAsDeleted();
            clientRepository.save(client);
        }
    }
}
