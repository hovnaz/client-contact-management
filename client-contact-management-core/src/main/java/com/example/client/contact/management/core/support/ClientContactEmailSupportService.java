package com.example.client.contact.management.core.support;

import com.example.client.contact.management.core.entity.ClientContactEmail;

public interface ClientContactEmailSupportService {

    ClientContactEmail getClientEmailByIdOrThrow(long id);
}
