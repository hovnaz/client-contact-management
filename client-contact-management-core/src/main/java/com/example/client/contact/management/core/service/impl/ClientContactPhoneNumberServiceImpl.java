package com.example.client.contact.management.core.service.impl;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.entity.ClientContactPhoneNumber;
import com.example.client.contact.management.core.mapper.ClientContactPhoneNumberMapper;
import com.example.client.contact.management.core.repository.ClientContactPhoneNumberRepository;
import com.example.client.contact.management.core.service.ClientContactPhoneNumberService;
import com.example.client.contact.management.core.support.ClientContactPhoneNumberSupportService;
import com.example.client.contact.management.core.support.ClientSupportService;
import com.example.client.contact.management.data.transfer.request.ClientContactPhoneNumberRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactPhoneNumberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientContactPhoneNumberServiceImpl implements ClientContactPhoneNumberService {

    private final ClientSupportService clientSupportService;
    private final ClientContactPhoneNumberSupportService clientContactPhoneNumberSupportService;
    private final ClientContactPhoneNumberMapper clientContactPhoneNumberMapper;
    private final ClientContactPhoneNumberRepository clientContactPhoneNumberRepository;

    @Override
    public ClientContactPhoneNumberResponse addPhoneNumber(ClientContactPhoneNumberRequest clientContactPhoneNumberRequest) {
        Client client = clientSupportService.getClientByIdOrThrow(clientContactPhoneNumberRequest.getClientId());
        ClientContactPhoneNumber contactPhoneNumber = clientContactPhoneNumberMapper.toEntity(clientContactPhoneNumberRequest);
        contactPhoneNumber.setClient(client);
        ClientContactPhoneNumber save = clientContactPhoneNumberRepository.save(contactPhoneNumber);
        return clientContactPhoneNumberMapper.toResponse(save);
    }

    @Override
    public ClientContactPhoneNumberResponse findById(long id) {
        ClientContactPhoneNumber clientPhoneNumber = clientContactPhoneNumberSupportService.getClientPhoneNumberByIdOrThrow(id);
        return clientContactPhoneNumberMapper.toResponse(clientPhoneNumber);
    }

    @Override
    public Page<ClientContactPhoneNumberResponse> findAllByClientId(long clientId, Pageable pageable) {
        clientSupportService.verifyClientExistsOrThrow(clientId);
        Page<ClientContactPhoneNumber> clientContactEmailPage = clientContactPhoneNumberRepository.findAllByClientIdAndDeletionStatusDeletedFlagIsFalse(clientId, pageable);
        return clientContactEmailPage.map(clientContactPhoneNumberMapper::toResponse);
    }

    @Override
    public void deleteById(long id) {
        ClientContactPhoneNumber clientContactPhoneNumber = clientContactPhoneNumberSupportService.getClientPhoneNumberByIdOrThrow(id);
        if (!clientContactPhoneNumber.getDeletionStatus().isDeleted()) {
            clientContactPhoneNumber.getDeletionStatus().markAsDeleted();
            clientContactPhoneNumberRepository.save(clientContactPhoneNumber);
        }
    }

    @Override
    public void deleteAllByClientId(long clientId) {
        clientSupportService.verifyClientExistsOrThrow(clientId);
        clientContactPhoneNumberRepository.deleteAllByClientId(clientId);
    }
}
