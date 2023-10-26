package com.example.client.contact.management.core.service.impl;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.entity.ClientContactEmail;
import com.example.client.contact.management.core.mapper.ClientContactEmailMapper;
import com.example.client.contact.management.core.repository.ClientContactEmailRepository;
import com.example.client.contact.management.core.service.ClientContactEmailService;
import com.example.client.contact.management.core.support.ClientContactEmailSupportService;
import com.example.client.contact.management.core.support.ClientSupportService;
import com.example.client.contact.management.data.transfer.request.ClientContactEmailRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactEmailResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientContactEmailServiceImpl implements ClientContactEmailService {

    private final ClientSupportService clientSupportService;
    private final ClientContactEmailSupportService clientContactEmailSupportService;
    private final ClientContactEmailMapper clientContactEmailMapper;
    private final ClientContactEmailRepository clientContactEmailRepository;

    // todo petq e unic lini partadir
    @Override
    public ClientContactEmailResponse addEmail(ClientContactEmailRequest contactEmailRequest) {
        Client client = clientSupportService.getClientByIdOrThrow(contactEmailRequest.getClientId());
        ClientContactEmail clientContactEmail = clientContactEmailMapper.toEntity(contactEmailRequest);
        clientContactEmail.setClient(client);
        ClientContactEmail save = clientContactEmailRepository.save(clientContactEmail);
        return clientContactEmailMapper.toResponse(save);
    }

    @Override
    public ClientContactEmailResponse findById(long id) {
        ClientContactEmail clientContactEmail = clientContactEmailSupportService.getClientEmailByIdOrThrow(id);
        return clientContactEmailMapper.toResponse(clientContactEmail);
    }

    @Override
    public Page<ClientContactEmailResponse> findAllByClientId(long clientId, Pageable pageable) {
        Page<ClientContactEmail> clientContactEmailPage = clientContactEmailRepository.findAllByClientIdAndDeletionStatusDeletedFlagIsFalse(clientId, pageable);
        return clientContactEmailPage.map(clientContactEmailMapper::toResponse);
    }

    @Override
    public void deleteById(long id) {
        ClientContactEmail clientContactEmail = clientContactEmailSupportService.getClientEmailByIdOrThrow(id);
        if (!clientContactEmail.getDeletionStatus().isDeleted()) {
            clientContactEmail.getDeletionStatus().markAsDeleted();
            clientContactEmailRepository.save(clientContactEmail);
        }
    }

    @Override
    public void deleteAllByClientId(long id) {
        clientContactEmailRepository.deleteAllByClientId(id);
    }
}