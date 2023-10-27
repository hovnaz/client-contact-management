package com.example.client.contact.management.data.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ClientContactPhoneNumberResponse class represents a response containing client contact phone number information.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientContactPhoneNumberResponse {

    private long id;
    private String phoneNumber;
}
