package com.example.client.contact.management.core.support.impl;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.exception.EntityNotFoundException;
import com.example.client.contact.management.core.exception.ErrorMessage;
import com.example.client.contact.management.core.repository.ClientRepository;
import com.example.client.contact.management.core.support.ClientSupportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The ClientSupportServiceImpl class provides the implementation of the ClientSupportService interface for support operations related to clients.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ClientSupportServiceImpl implements ClientSupportService {

    private final ClientRepository clientRepository;

    @Override
    public Client getClientByIdOrThrow(long id) {
        Optional<Client> clientOptional = clientRepository.findByIdAndDeletionStatusDeletedFlagIsFalse(id);
        if (clientOptional.isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.CLIENT_NOT_FOUND);
        }
        return clientOptional.get();
    }

    @Override
    public void verifyClientExistsOrThrow(long id) {
        log.info("Verifying client exists by ID: {}", id);

        Optional<Client> clientOptional = clientRepository.findByIdAndDeletionStatusDeletedFlagIsFalse(id);
        if (clientOptional.isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.CLIENT_NOT_FOUND);
        }

        log.info("Client with ID {} exists.", id);
    }
}
