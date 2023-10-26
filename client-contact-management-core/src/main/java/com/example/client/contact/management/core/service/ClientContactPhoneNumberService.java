package com.example.client.contact.management.core.service;

import com.example.client.contact.management.data.transfer.request.ClientContactPhoneNumberRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactPhoneNumberResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientContactPhoneNumberService {

    ClientContactPhoneNumberResponse addPhoneNumber(ClientContactPhoneNumberRequest clientContactPhoneNumberRequest);

    ClientContactPhoneNumberResponse findById(long id);

    Page<ClientContactPhoneNumberResponse> findAllByClientId(long clientId, Pageable pageable);

    void deleteById(long id);

    void deleteAllByClientId(long clientId);
}
