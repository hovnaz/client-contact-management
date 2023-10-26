package com.example.client.contact.management.web.endpoint;

import com.example.client.contact.management.core.service.ClientContactPhoneNumberService;
import com.example.client.contact.management.data.transfer.request.ClientContactPhoneNumberRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactPhoneNumberResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client-contact-phone-numbers")
@RequiredArgsConstructor
public class ClientContactPhoneNumberEndpoint {

    private final ClientContactPhoneNumberService clientContactPhoneNumberService;


    @PostMapping
    public ResponseEntity<ClientContactPhoneNumberResponse> addPhoneNumber(@RequestBody @Valid ClientContactPhoneNumberRequest request) {
        ClientContactPhoneNumberResponse response = clientContactPhoneNumberService.addPhoneNumber(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientContactPhoneNumberResponse> getPhoneNumberById(@PathVariable long id) {
        ClientContactPhoneNumberResponse response = clientContactPhoneNumberService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-client/{clientId}")
    public ResponseEntity<Page<ClientContactPhoneNumberResponse>> getPhoneNumbersByClientId(
            @PathVariable long clientId,
            @PageableDefault Pageable pageable
    ) {
        Page<ClientContactPhoneNumberResponse> response = clientContactPhoneNumberService.findAllByClientId(clientId, pageable);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoneNumber(@PathVariable long id) {
        clientContactPhoneNumberService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/by-client/{clientId}")
    public ResponseEntity<Void> deletePhoneNumbersByClientId(@PathVariable long clientId) {
        clientContactPhoneNumberService.deleteAllByClientId(clientId);
        return ResponseEntity.noContent().build();
    }
}
