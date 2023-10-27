package com.example.client.contact.management.core.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Client class represents information about a client entity in the system.
 * <p>
 * This class is marked as an @Entity, indicating that it is a JPA entity mapped
 * to a database table named "client".
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client extends BaseEntity {

    private String clientName;

    private String email;

    @Embedded
    private Auditable auditable;

    @Embedded
    private DeletionStatus deletionStatus;

    public Client() {
        this.auditable = new Auditable();
        this.deletionStatus = new DeletionStatus();
    }
}
