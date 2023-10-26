package com.example.client.contact.management.core.support.impl;

import com.example.client.contact.management.core.entity.ClientContactEmail;
import com.example.client.contact.management.core.exception.EntityNotFoundException;
import com.example.client.contact.management.core.exception.ErrorMessage;
import com.example.client.contact.management.core.repository.ClientContactEmailRepository;
import com.example.client.contact.management.core.support.ClientContactEmailSupportService;
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
            throw new EntityNotFoundException(ErrorMessage.CLIENT_EMAIL_NOT_FOUND);
        }
        return clientContactEmailOptional.get();
    }
}
