package com.example.client.contact.management.core.service;

import com.example.client.contact.management.data.transfer.request.ClientRequest;
import com.example.client.contact.management.data.transfer.response.ClientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    ClientResponse addClient(ClientRequest clientRequest);

    ClientResponse findById(long id);

    Page<ClientResponse> findAll(Pageable pageable);

    void deleteById(long id);
}
