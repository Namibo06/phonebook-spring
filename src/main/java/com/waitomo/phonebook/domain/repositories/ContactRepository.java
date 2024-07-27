package com.waitomo.phonebook.domain.repositories;

import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ContactRepository {
    ContactEntity save(ContactEntity contact);

    Optional<ContactEntity> findByNameOrNumber(String nameOrNumber);

    Page<ContactResponse> findAllContacts(Pageable pageable);

    ContactEntity update(String number, Contact contact);

    void delete(String number);

    Boolean exists(String number);
}
