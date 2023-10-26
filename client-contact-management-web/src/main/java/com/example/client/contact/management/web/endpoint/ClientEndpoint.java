package com.example.client.contact.management.web.endpoint;

import com.example.client.contact.management.core.service.ClientService;
import com.example.client.contact.management.data.transfer.request.ClientRequest;
import com.example.client.contact.management.data.transfer.response.ClientResponse;
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
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientEndpoint {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> addClient(@RequestBody @Valid ClientRequest request) {
        ClientResponse response = clientService.addClient(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable long id) {
        ClientResponse response = clientService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponse>> getClients(@PageableDefault Pageable pageable) {
        Page<ClientResponse> response = clientService.findAll(pageable);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
