package com.example.client.contact.management.core.repository;

import com.example.client.contact.management.core.entity.ClientContactEmail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * The ClientContactEmailRepository interface provides data access methods for client contact email entities.
 */
public interface ClientContactEmailRepository extends JpaRepository<ClientContactEmail, Long> {

    /**
     * Find a client contact email by its ID when the deletion status is not set to 'deleted'.
     *
     * @param id The ID of the client contact email to find.
     * @return An Optional containing the client contact email if found and not deleted, or an empty Optional.
     */
    Optional<ClientContactEmail> findByIdAndDeletionStatusDeletedFlagIsFalse(long id);

    /**
     * Find a page of client contact emails for a specific client when the deletion status is not set to 'deleted'.
     *
     * @param clientId The ID of the client for whom to retrieve client contact emails.
     * @param pageable The pagination information for the result page.
     * @return A Page containing client contact emails for the client that are not deleted.
     */
    Page<ClientContactEmail> findAllByClientIdAndDeletionStatusDeletedFlagIsFalse(long clientId, Pageable pageable);

    /**
     * Delete all client contact emails for a specific client by marking them as 'deleted'.
     *
     * @param clientId The ID of the client for whom to delete client contact emails.
     */
    @Transactional
    @Modifying
    @Query("UPDATE ClientContactEmail c SET c.deletionStatus.deletedFlag = true WHERE c.client.id = :clientId AND c.deletionStatus.deletedFlag = false")
    void deleteAllByClientId(@Param("clientId") long clientId);
}
