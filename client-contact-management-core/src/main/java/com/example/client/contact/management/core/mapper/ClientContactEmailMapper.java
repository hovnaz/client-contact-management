package com.example.client.contact.management.core.mapper;

import com.example.client.contact.management.core.entity.ClientContactEmail;
import com.example.client.contact.management.core.mapper.base.BaseMapper;
import com.example.client.contact.management.data.transfer.request.ClientContactEmailRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactEmailResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientContactEmailMapper implements BaseMapper<ClientContactEmail, ClientContactEmailRequest, ClientContactEmailResponse> {

    private final ModelMapper modelMapper;

    @Override
    public ClientContactEmail toEntity(ClientContactEmailRequest clientContactEmailRequest) {
        return modelMapper.map(clientContactEmailRequest, ClientContactEmail.class);
    }

    @Override
    public ClientContactEmailResponse toResponse(ClientContactEmail clientContactEmail) {
        return modelMapper.map(clientContactEmail, ClientContactEmailResponse.class);
    }
}
