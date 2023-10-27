package com.example.client.contact.management.core.service;

import com.example.client.contact.management.data.transfer.request.ClientContactPhoneNumberRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactPhoneNumberResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The ClientContactPhoneNumberService interface defines the contract for managing client contact phone numbers.
 */
public interface ClientContactPhoneNumberService {

    /**
     * Add a client contact phone number for a client.
     *
     * @param clientContactPhoneNumberRequest The request for adding a client contact phone number.
     * @return The response containing the added client contact phone number.
     */
    ClientContactPhoneNumberResponse addPhoneNumber(ClientContactPhoneNumberRequest clientContactPhoneNumberRequest);

    /**
     * Find a client contact phone number by its ID.
     *
     * @param id The ID of the client contact phone number to find.
     * @return The response containing the client contact phone number if found, or an exception if not found.
     */
    ClientContactPhoneNumberResponse findById(long id);

    /**
     * Find all client contact phone numbers for a specific client.
     *
     * @param clientId The ID of the client for whom to retrieve client contact phone numbers.
     * @param pageable The pagination information for the result page.
     * @return A page of client contact phone number responses.
     */
    Page<ClientContactPhoneNumberResponse> findAllByClientId(long clientId, Pageable pageable);

    /**
     * Delete a client contact phone number by marking it as 'deleted'.
     *
     * @param id The ID of the client contact phone number to delete.
     */
    void deleteById(long id);

    /**
     * Delete all client contact phone numbers for a specific client by marking them as 'deleted'.
     *
     * @param clientId The ID of the client for whom to delete client contact phone numbers.
     */
    void deleteAllByClientId(long clientId);
}
