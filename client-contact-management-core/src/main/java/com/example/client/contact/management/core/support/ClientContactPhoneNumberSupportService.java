package com.example.client.contact.management.core.support;

import com.example.client.contact.management.core.entity.ClientContactPhoneNumber;
import com.example.client.contact.management.core.exception.EntityNotFoundException;

/**
 * The ClientContactPhoneNumberSupportService interface defines support operations for managing client contact phone numbers.
 */
public interface ClientContactPhoneNumberSupportService {

    /**
     * Get a client contact phone number by its ID or throw an exception if not found.
     *
     * @param id The ID of the client contact phone number to retrieve.
     * @return The client contact phone number if found.
     * @throws EntityNotFoundException if the client contact phone number with the given ID is not found.
     */
    ClientContactPhoneNumber getClientPhoneNumberByIdOrThrow(long id);
}
