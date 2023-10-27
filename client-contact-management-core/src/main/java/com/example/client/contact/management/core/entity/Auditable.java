package com.example.client.contact.management.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * The Auditable class represents audit information for an entity.
 * <p>
 * This class is marked as @Embeddable, indicating that it can be embedded
 * within other entity classes to provide audit information.
 */
@Embeddable
public class Auditable {

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;
}
