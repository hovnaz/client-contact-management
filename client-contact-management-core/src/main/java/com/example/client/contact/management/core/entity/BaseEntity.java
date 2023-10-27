package com.example.client.contact.management.core.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * The BaseEntity class is an abstract base class for entity objects in the system.
 * <p>
 * This class is marked as a @MappedSuperclass, indicating that it provides common
 * attributes and functionality to be inherited by other entity classes.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
