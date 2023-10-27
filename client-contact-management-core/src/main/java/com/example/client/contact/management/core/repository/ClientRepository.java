package com.example.client.contact.management.core.repository;

import com.example.client.contact.management.core.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The ClientRepository interface provides data access methods for client entities.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

    /**
     * Find a client by email when the deletion status is not set to 'deleted'.
     *
     * @param email The email of the client to find.
     * @return An Optional containing the client if found and not deleted, or an empty Optional.
     */
    Optional<Client> findByEmailAndDeletionStatusDeletedFlagIsFalse(String email);

    /**
     * Find a client by ID when the deletion status is not set to 'deleted'.
     *
     * @param id The ID of the client to find.
     * @return An Optional containing the client if found and not deleted, or an empty Optional.
     */
    Optional<Client> findByIdAndDeletionStatusDeletedFlagIsFalse(long id);

    /**
     * Find a page of clients when the deletion status is not set to 'deleted'.
     *
     * @param pageable The pagination information for the result page.
     * @return A Page containing clients that are not deleted.
     */
    Page<Client> findAllByDeletionStatusDeletedFlagIsFalse(Pageable pageable);
}

