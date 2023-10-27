package com.example.client.contact.management.core.support;

import com.example.client.contact.management.core.entity.ClientContactEmail;
import com.example.client.contact.management.core.exception.EntityNotFoundException;

/**
 * The ClientContactEmailSupportService interface defines support operations for managing client contact emails.
 */
public interface ClientContactEmailSupportService {

    /**
     * Get a client contact email by its ID or throw an exception if not found.
     *
     * @param id The ID of the client contact email to retrieve.
     * @return The client contact email if found.
     * @throws EntityNotFoundException if the client contact email with the given ID is not found.
     */
    ClientContactEmail getClientEmailByIdOrThrow(long id);
}
