package com.waitomo.phonebook.domain.repositories;

import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.web.dtos.ContactResponseDTO;
import com.waitomo.phonebook.infrastructure.web.dtos.MessageStatusResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContactRepository {
    Contact save(Contact contact);

    Optional<Contact> findByName(String name);

    Optional<Contact> findByNumberPhone(String phone);

    Page<ContactResponseDTO> findAll(Pageable pageable);

    MessageStatusResponseDTO update(String number, Contact contact);

    MessageStatusResponseDTO delete(String number);

    Boolean exists(String number);
}
