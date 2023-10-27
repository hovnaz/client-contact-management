package com.example.client.contact.management.core.service;

import com.example.client.contact.management.data.transfer.request.ClientContactEmailRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactEmailResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The ClientContactEmailService interface defines the contract for managing client contact emails.
 */
public interface ClientContactEmailService {

    /**
     * Add a client contact email for a client.
     *
     * @param contactEmailRequest The request for adding a client contact email.
     * @return The response containing the added client contact email.
     */
    ClientContactEmailResponse addEmail(ClientContactEmailRequest contactEmailRequest);

    /**
     * Find a client contact email by its ID.
     *
     * @param id The ID of the client contact email to find.
     * @return The response containing the client contact email if found, or an exception if not found.
     */
    ClientContactEmailResponse findById(long id);

    /**
     * Find all client contact emails for a specific client.
     *
     * @param clientId The ID of the client for whom to retrieve client contact emails.
     * @param pageable The pagination information for the result page.
     * @return A page of client contact email responses.
     */
    Page<ClientContactEmailResponse> findAllByClientId(long clientId, Pageable pageable);

    /**
     * Delete a client contact email by marking it as 'deleted'.
     *
     * @param id The ID of the client contact email to delete.
     */
    void deleteById(long id);

    /**
     * Delete all client contact emails for a specific client by marking them as 'deleted'.
     *
     * @param clientId The ID of the client for whom to delete client contact emails.
     */
    void deleteAllByClientId(long clientId);
}
