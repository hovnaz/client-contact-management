package com.example.client.contact.management.core.entity;

import jakarta.persistence.Embeddable;

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
