package com.example.client.contact.management.core.support;

import com.example.client.contact.management.core.entity.ClientContactPhoneNumber;

public interface ClientContactPhoneNumberSupportService {

    ClientContactPhoneNumber getClientPhoneNumberByIdOrThrow(long id);
}
