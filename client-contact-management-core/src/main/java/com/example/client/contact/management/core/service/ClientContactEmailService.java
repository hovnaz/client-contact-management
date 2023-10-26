package com.example.client.contact.management.core.service;

import com.example.client.contact.management.data.transfer.request.ClientContactEmailRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactEmailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientContactEmailService {

    ClientContactEmailResponse addEmail(ClientContactEmailRequest contactEmailRequest);

    ClientContactEmailResponse findById(long id);

    Page<ClientContactEmailResponse> findAllByClientId(long clientId, Pageable pageable);

    void deleteById(long id);

    void deleteAllByClientId(long id);
}
