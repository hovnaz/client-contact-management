package com.example.client.contact.management.core.mapper;

import com.example.client.contact.management.core.entity.ClientContactPhoneNumber;
import com.example.client.contact.management.core.mapper.base.BaseMapper;
import com.example.client.contact.management.data.transfer.request.ClientContactPhoneNumberRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactPhoneNumberResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * The ClientContactPhoneNumberMapper class is responsible for mapping between ClientContactPhoneNumber entities,
 * ClientContactPhoneNumberRequest DTOs, and ClientContactPhoneNumberResponse DTOs.
 * <p>
 * This class implements the BaseMapper interface to provide methods for converting
 * between different representations of ClientContactPhoneNumber data, such as entities and DTOs.
 */
@Service
@RequiredArgsConstructor
public class ClientContactPhoneNumberMapper implements BaseMapper<ClientContactPhoneNumber, ClientContactPhoneNumberRequest, ClientContactPhoneNumberResponse> {

    private final ModelMapper modelMapper;

    @Override
    public ClientContactPhoneNumber toEntity(ClientContactPhoneNumberRequest clientContactPhoneNumberRequest) {
        return modelMapper.map(clientContactPhoneNumberRequest, ClientContactPhoneNumber.class);
    }

    @Override
    public ClientContactPhoneNumberResponse toResponse(ClientContactPhoneNumber clientContactPhoneNumber) {
        return modelMapper.map(clientContactPhoneNumber, ClientContactPhoneNumberResponse.class);
    }
}
