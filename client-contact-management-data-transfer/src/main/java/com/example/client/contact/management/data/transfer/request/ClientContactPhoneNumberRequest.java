package com.example.client.contact.management.data.transfer.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientContactPhoneNumberRequest {

    @Positive(message = "clientId must be a positive number")
    @NotNull(message = "Client ID cannot be null")
    private long clientId;

    @Pattern(regexp = "^(\\d{3}-\\d{3}-\\d{4}|\\d{10})$", message = "Invalid phone number format. It should be a 10-digit number or in the format xxx-xxx-xxxx.")
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;
}
