package com.waitomo.phonebook.application.services;

import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContactService {
    ContactEntity createContactService(ContactEntity contact);

    Page<ContactResponse> findAllContactService(Pageable pageable);

    Optional<ContactEntity> findContactByNameOrNumberService(String nameOrNumber);

    ContactEntity updateContactService(String number, Contact contact);

    void deleteContactService(String number);

    Boolean existsContactService(String number);
}
