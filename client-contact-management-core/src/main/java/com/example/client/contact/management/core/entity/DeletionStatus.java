package com.example.client.contact.management.core.entity;

import jakarta.persistence.Embeddable;

/**
 * The DeletionStatus class is used to manage the deletion status of entities.
 * <p>
 * This class is marked as an @Embeddable, indicating that it can be embedded
 * within other entity classes to provide deletion status information.
 */
@Embeddable
public class DeletionStatus {

    private Boolean deletedFlag;

    public DeletionStatus() {
        this.deletedFlag = false;
    }

    public Boolean isDeleted() {
        return deletedFlag;
    }

    public void markAsDeleted() {
        deletedFlag = true;
    }
}
