package com.waitomo.phonebook.application.services;

import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.web.dtos.ContactResponseDTO;
import com.waitomo.phonebook.infrastructure.web.dtos.MessageStatusResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContactService {
    Contact createContactService(Contact contact);

    Page<ContactResponseDTO> findAllContactService(Pageable pageable);

    Optional<Contact> findContactByNameService(String name);

    Optional<Contact> findContactByNumberPhoneService(String number);

    MessageStatusResponseDTO updateContactService(String number,Contact contact);

    MessageStatusResponseDTO deleteContactService(String number);

    Boolean existsContactService(String number);
}
