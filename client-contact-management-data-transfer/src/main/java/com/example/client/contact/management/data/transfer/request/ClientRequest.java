package com.example.client.contact.management.data.transfer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ClientRequest class represents a request for creating or updating a client.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientRequest {

    @NotBlank(message = "Client name cannot be blank")
    private String clientName;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
}
