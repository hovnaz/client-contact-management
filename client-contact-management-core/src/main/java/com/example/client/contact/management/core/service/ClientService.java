package com.example.client.contact.management.core.service;

import com.example.client.contact.management.data.transfer.request.ClientRequest;
import com.example.client.contact.management.data.transfer.response.ClientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The ClientService interface defines the contract for managing clients.
 */
public interface ClientService {

    /**
     * Add a client.
     *
     * @param clientRequest The request for adding a client.
     * @return The response containing the added client.
     */
    ClientResponse addClient(ClientRequest clientRequest);

    /**
     * Find a client by its ID.
     *
     * @param id The ID of the client to find.
     * @return The response containing the client if found, or an exception if not found.
     */
    ClientResponse findById(long id);

    /**
     * Find all clients.
     *
     * @param pageable The pagination information for the result page.
     * @return A page of client responses.
     */
    Page<ClientResponse> findAll(Pageable pageable);

    /**
     * Delete a client by marking it as 'deleted' and also delete associated contact information (phone numbers and emails).
     *
     * @param id The ID of the client to delete.
     */
    void deleteById(long id);
}
