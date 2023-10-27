package com.example.client.contact.management.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The ClientContactEmail class represents an email address associated with a client contact.
 * <p>
 * This class is marked as an @Entity, indicating that it is a JPA entity mapped
 * to a database table named "client_contact_email."
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "client_contact_email")
public class ClientContactEmail extends BaseEntity {

    @ManyToOne
    private Client client;

    @Column(nullable = false)
    private String email;

    @Embedded
    private Auditable auditable;

    @Embedded
    private DeletionStatus deletionStatus;

    public ClientContactEmail() {
        this.auditable = new Auditable();
        this.deletionStatus = new DeletionStatus();
    }
}
