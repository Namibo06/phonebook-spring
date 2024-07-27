package com.waitomo.phonebook.application.services.impl;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.domain.repositories.ContactRepository;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactImplService implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactImplService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactEntity createContactService(ContactEntity contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Page<ContactResponse> findAllContactService(Pageable pageable) {
        return contactRepository.findAllContacts(pageable);
    }

    @Override
    public Optional<ContactEntity> findContactByNameOrNumberService(String nameOrNumber) {
        return contactRepository.findByNameOrNumber(nameOrNumber);
    }

    @Override
    public ContactEntity updateContactService(String number, Contact contact) {
        return contactRepository.update(number,contact);
    }

    @Override
    public MessageStatusResponse deleteContactService(String number) {
        return contactRepository.delete(number);
    }

    @Override
    public Boolean existsContactService(String number) {
        return contactRepository.exists(number);
    }
}
