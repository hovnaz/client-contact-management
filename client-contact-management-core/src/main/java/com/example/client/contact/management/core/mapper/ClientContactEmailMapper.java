package com.example.client.contact.management.core.mapper;

import com.example.client.contact.management.core.entity.ClientContactEmail;
import com.example.client.contact.management.core.mapper.base.BaseMapper;
import com.example.client.contact.management.data.transfer.request.ClientContactEmailRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactEmailResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * The ClientContactEmailMapper class is responsible for mapping between ClientContactEmail entities,
 * ClientContactEmailRequest DTOs, and ClientContactEmailResponse DTOs.
 * <p>
 * This class implements the BaseMapper interface to provide methods for converting
 * between different representations of ClientContactEmail data, such as entities and DTOs.
 */
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
