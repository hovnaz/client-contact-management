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

/**
 * The ClientServiceImpl class provides the implementation of the ClientService interface for managing clients.
 */
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
        log.info("Adding a new client with email: {}", clientRequest.getEmail());

        Optional<Client> clientOptional = clientRepository.findByEmailAndDeletionStatusDeletedFlagIsFalse(clientRequest.getEmail());
        if (clientOptional.isPresent()) {
            throw new ConflictException(ErrorMessage.CLIENT_EMAIL_ALREADY_EXIST);
        }
        Client client = clientMapper.toEntity(clientRequest);
        Client save = clientRepository.save(client);

        log.info("Added a new client with ID: {}", save.getId());

        return clientMapper.toResponse(save);
    }

    @Override
    public ClientResponse findById(long id) {
        log.info("Retrieving client by ID: {}", id);

        Client client = clientSupportService.getClientByIdOrThrow(id);

        log.info("Retrieved client with ID: {}", id);

        return clientMapper.toResponse(client);
    }

    @Override
    public Page<ClientResponse> findAll(Pageable pageable) {
        log.info("Retrieving all clients.");

        Page<Client> clientPage = clientRepository.findAllByDeletionStatusDeletedFlagIsFalse(pageable);

        log.info("Retrieved {} clients.", clientPage.getNumberOfElements());

        return clientPage.map(clientMapper::toResponse);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        log.info("Deleting client by ID: {}", id);

        Client client = clientSupportService.getClientByIdOrThrow(id);
        if (!client.getDeletionStatus().isDeleted()) {
            log.info("Deleting all contact phone numbers and email addresses for client with ID: {}", id);

            clientContactPhoneNumberService.deleteAllByClientId(id);
            clientContactEmailService.deleteAllByClientId(id);
            client.getDeletionStatus().markAsDeleted();
            clientRepository.save(client);

            log.info("Deleted client with ID: {}", id);
        }
    }
}
