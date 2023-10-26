package com.example.client.contact.management.web.endpoint;

import com.example.client.contact.management.core.service.ClientContactEmailService;
import com.example.client.contact.management.data.transfer.request.ClientContactEmailRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactEmailResponse;
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
@RequestMapping("/api/client-contact-emails")
@RequiredArgsConstructor
public class ClientContactEmailEndpoint {

    private final ClientContactEmailService clientContactEmailService;

    @PostMapping
    public ResponseEntity<ClientContactEmailResponse> addEmail(@RequestBody @Valid ClientContactEmailRequest request) {
        ClientContactEmailResponse response = clientContactEmailService.addEmail(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientContactEmailResponse> getEmailById(@PathVariable long id) {
        ClientContactEmailResponse response = clientContactEmailService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-client/{clientId}")
    public ResponseEntity<Page<ClientContactEmailResponse>> getEmailsByClientId(
            @PathVariable long clientId,
            @PageableDefault Pageable pageable
    ) {
        Page<ClientContactEmailResponse> response = clientContactEmailService.findAllByClientId(clientId, pageable);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable long id) {
        clientContactEmailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/by-client/{clientId}")
    public ResponseEntity<Void> deleteEmailsByClientId(@PathVariable long clientId) {
        clientContactEmailService.deleteAllByClientId(clientId);
        return ResponseEntity.noContent().build();
    }
}
