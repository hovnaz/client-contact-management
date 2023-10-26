package com.example.client.contact.management.data.transfer.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientContactPhoneNumberRequest {

    private long clientId;
    private String phoneNumber;
}
