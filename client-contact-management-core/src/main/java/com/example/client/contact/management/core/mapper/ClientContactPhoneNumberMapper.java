package com.example.client.contact.management.core.mapper;

import com.example.client.contact.management.core.entity.ClientContactPhoneNumber;
import com.example.client.contact.management.core.mapper.base.BaseMapper;
import com.example.client.contact.management.data.transfer.request.ClientContactPhoneNumberRequest;
import com.example.client.contact.management.data.transfer.response.ClientContactPhoneNumberResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
