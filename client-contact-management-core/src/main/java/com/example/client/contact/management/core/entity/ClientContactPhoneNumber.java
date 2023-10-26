package com.example.client.contact.management.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "client_contact_phone_number")
public class ClientContactPhoneNumber extends BaseEntity {

    @ManyToOne
    private Client client;

    @Column(nullable = false)
    private String phoneNumber;

    @Embedded
    private Auditable auditable;

    @Embedded
    private DeletionStatus deletionStatus;

    public ClientContactPhoneNumber() {
        this.auditable = new Auditable();
        this.deletionStatus = new DeletionStatus();
    }
}
