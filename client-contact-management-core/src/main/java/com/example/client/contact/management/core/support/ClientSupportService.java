package com.example.client.contact.management.core.support;

import com.example.client.contact.management.core.entity.Client;


public interface ClientSupportService {

    Client getClientByIdOrThrow(long id);

    void verifyClientExistsOrThrow(long clientId);
}
