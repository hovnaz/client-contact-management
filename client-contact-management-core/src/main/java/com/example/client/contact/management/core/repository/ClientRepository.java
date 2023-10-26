package com.example.client.contact.management.core.repository;

import com.example.client.contact.management.core.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmailAndDeletionStatusDeletedFlagIsFalse(String email);

    Optional<Client> findByIdAndDeletionStatusDeletedFlagIsFalse(long id);

    Page<Client> findAllByDeletionStatusDeletedFlagIsFalse(Pageable pageable);
}
