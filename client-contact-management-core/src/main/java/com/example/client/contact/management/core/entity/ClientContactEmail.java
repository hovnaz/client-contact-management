package com.example.client.contact.management.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClientContactEmail extends BaseEntity {

    @ManyToOne
    private Client client;

    @Column(unique = true, nullable = false)
    private String email;

    @Embedded
    private Auditable auditable;

    @Embedded
    private DeletionStatus deletionStatus;
}
