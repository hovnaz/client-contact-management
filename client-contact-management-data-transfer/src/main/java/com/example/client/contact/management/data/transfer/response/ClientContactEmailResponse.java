package com.example.client.contact.management.data.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The ClientContactEmailResponse class represents a response containing client contact email information.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientContactEmailResponse {

    private long id;
    private String email;
}
