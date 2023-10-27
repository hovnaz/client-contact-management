package com.example.client.contact.management.core.support;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.exception.EntityNotFoundException;


/**
 * The ClientSupportService interface defines support operations for managing clients.
 */
public interface ClientSupportService {

    /**
     * Get a client by its ID or throw an exception if not found.
     *
     * @param id The ID of the client to retrieve.
     * @return The client if found.
     * @throws EntityNotFoundException if the client with the given ID is not found.
     */
    Client getClientByIdOrThrow(long id);

    /**
     * Verify the existence of a client by its ID or throw an exception if not found.
     *
     * @param clientId The ID of the client to verify.
     * @throws EntityNotFoundException if the client with the given ID is not found.
     */
    void verifyClientExistsOrThrow(long clientId);
}
