package com.example.client.contact.management.core.support.impl;

import com.example.client.contact.management.core.entity.ClientContactPhoneNumber;
import com.example.client.contact.management.core.repository.ClientContactPhoneNumberRepository;
import com.example.client.contact.management.core.support.ClientContactPhoneNumberSupportService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientContactPhoneNumberSupportServiceImpl implements ClientContactPhoneNumberSupportService {

    private final ClientContactPhoneNumberRepository clientContactPhoneNumberRepository;

    @Override
    public ClientContactPhoneNumber getClientPhoneNumberByIdOrThrow(long id) {
        Optional<ClientContactPhoneNumber> clientContactPhoneNumberOptional = clientContactPhoneNumberRepository.findByIdAndDeletionStatusDeletedFlagIsFalse(id);
        if (clientContactPhoneNumberOptional.isEmpty()) {
            throw new EntityNotFoundException("Client phone number with id: " + id + " not found");
        }
        return clientContactPhoneNumberOptional.get();
    }
}
