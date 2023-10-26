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

public interface ClientContactPhoneNumberRepository extends JpaRepository<ClientContactPhoneNumber, Long> {

    Optional<ClientContactPhoneNumber> findByIdAndDeletionStatusDeletedFlagIsFalse(long id);

    Page<ClientContactPhoneNumber> findAllByClientIdAndDeletionStatusDeletedFlagIsFalse(long clientId, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE ClientContactPhoneNumber c SET c.deletionStatus.deletedFlag = true WHERE c.client.id = :clientId AND c.deletionStatus.deletedFlag = false")
    void deleteAllByClientId(@Param("clientId") long clientId);
}
