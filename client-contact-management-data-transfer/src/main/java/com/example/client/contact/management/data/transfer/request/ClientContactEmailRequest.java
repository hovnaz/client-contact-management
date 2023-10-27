package com.example.client.contact.management.data.transfer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ClientContactEmailRequest class represents a request for creating or updating a client's contact email.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientContactEmailRequest {

    @Positive(message = "clientId must be a positive number")
    @NotNull(message = "Client ID cannot be null")
    private Long clientId;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
}
