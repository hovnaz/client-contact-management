package com.example.client.contact.management.core.support.impl;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.repository.ClientRepository;
import com.example.client.contact.management.core.support.ClientSupportService;
import jakarta.persistence.EntityNotFoundException;
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
            throw new EntityNotFoundException("Client with id: " + id + " not found");
        }
        return clientOptional.get();
    }
}
