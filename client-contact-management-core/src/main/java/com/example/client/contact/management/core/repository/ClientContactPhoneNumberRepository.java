package com.example.client.contact.management.core.repository;

import com.example.client.contact.management.core.entity.ClientContactPhoneNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * The ClientContactPhoneNumberRepository interface provides data access methods for client contact phone number entities.
 */
public interface ClientContactPhoneNumberRepository extends JpaRepository<ClientContactPhoneNumber, Long> {

    /**
     * Find a client contact phone number by its ID when the deletion status is not set to 'deleted'.
     *
     * @param id The ID of the client contact phone number to find.
     * @return An Optional containing the client contact phone number if found and not deleted, or an empty Optional.
     */
    Optional<ClientContactPhoneNumber> findByIdAndDeletionStatusDeletedFlagIsFalse(long id);

    /**
     * Find a page of client contact phone numbers for a specific client when the deletion status is not set to 'deleted'.
     *
     * @param clientId The ID of the client for whom to retrieve client contact phone numbers.
     * @param pageable The pagination information for the result page.
     * @return A Page containing client contact phone numbers for the client that are not deleted.
     */
    Page<ClientContactPhoneNumber> findAllByClientIdAndDeletionStatusDeletedFlagIsFalse(long clientId, Pageable pageable);

    /**
     * Delete all client contact phone numbers for a specific client by marking them as 'deleted'.
     *
     * @param clientId The ID of the client for whom to delete client contact phone numbers.
     */
    @Transactional
    @Modifying
    @Query("UPDATE ClientContactPhoneNumber c SET c.deletionStatus.deletedFlag = true WHERE c.client.id = :clientId AND c.deletionStatus.deletedFlag = false")
    void deleteAllByClientId(@Param("clientId") long clientId);
}
