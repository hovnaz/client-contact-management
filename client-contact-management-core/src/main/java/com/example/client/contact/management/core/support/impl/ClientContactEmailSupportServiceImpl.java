package com.example.client.contact.management.core.support.impl;

import com.example.client.contact.management.core.entity.ClientContactEmail;
import com.example.client.contact.management.core.repository.ClientContactEmailRepository;
import com.example.client.contact.management.core.support.ClientContactEmailSupportService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientContactEmailSupportServiceImpl implements ClientContactEmailSupportService {

    private final ClientContactEmailRepository clientContactEmailRepository;

    @Override
    public ClientContactEmail getClientEmailByIdOrThrow(long id) {
        Optional<ClientContactEmail> clientContactEmailOptional = clientContactEmailRepository.findByIdAndDeletionStatusDeletedFlagIsFalse(id);
        if (clientContactEmailOptional.isEmpty()) {
            throw new EntityNotFoundException("Client contact with id: " + id + " not found");
        }
        return clientContactEmailOptional.get();
    }
}
