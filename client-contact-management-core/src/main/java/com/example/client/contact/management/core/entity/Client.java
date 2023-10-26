package com.example.client.contact.management.core.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
