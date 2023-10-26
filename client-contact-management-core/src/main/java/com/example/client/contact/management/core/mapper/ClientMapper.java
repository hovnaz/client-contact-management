package com.example.client.contact.management.core.mapper;

import com.example.client.contact.management.core.entity.Client;
import com.example.client.contact.management.core.mapper.base.BaseMapper;
import com.example.client.contact.management.data.transfer.request.ClientRequest;
import com.example.client.contact.management.data.transfer.response.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientMapper implements BaseMapper<Client, ClientRequest, ClientResponse> {

    private final ModelMapper modelMapper;

    @Override
    public Client toEntity(ClientRequest clientRequest) {
        return modelMapper.map(clientRequest, Client.class);
    }

    @Override
    public ClientResponse toResponse(Client client) {
        return modelMapper.map(client, ClientResponse.class);
    }
}
