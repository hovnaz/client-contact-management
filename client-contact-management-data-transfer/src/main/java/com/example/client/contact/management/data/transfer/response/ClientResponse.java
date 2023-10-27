package com.example.client.contact.management.data.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ClientResponse class represents a response containing client information.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponse {

    private long id;
    private String clientName;
    private String email;
}
