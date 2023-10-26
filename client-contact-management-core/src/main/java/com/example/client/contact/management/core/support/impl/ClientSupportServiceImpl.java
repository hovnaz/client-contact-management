package com.example.client.contact.management.core.support.impl;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.exception.EntityNotFoundException;
import com.example.client.contact.management.core.exception.ErrorMessage;
import com.example.client.contact.management.core.repository.ClientRepository;
import com.example.client.contact.management.core.support.ClientSupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
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
        Optional<Client> clientOptional = clientRepository.findByIdAndDeletionStatusDeletedFlagIsFalse(id);
        if (clientOptional.isEmpty()) {
            throw new EntityNotFoundException(ErrorMessage.CLIENT_NOT_FOUND);
        }
    }
}
