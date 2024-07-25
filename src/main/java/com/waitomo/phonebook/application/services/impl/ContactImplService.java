package com.waitomo.phonebook.application.services.impl;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.domain.repositories.ContactRepository;
import com.waitomo.phonebook.infrastructure.web.dtos.ContactResponseDTO;
import com.waitomo.phonebook.infrastructure.web.dtos.MessageStatusResponseDTO;
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
    public Contact createContactService(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Page<ContactResponseDTO> findAllContactService(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public Optional<Contact> findContactByNameService(String name) {
        return contactRepository.findByName(name);
    }

    @Override
    public Optional<Contact> findContactByNumberPhoneService(String number) {
        return contactRepository.findByNumberPhone(number);
    }

    @Override
    public MessageStatusResponseDTO updateContactService(String number, Contact contact) {
        return contactRepository.update(number,contact);
    }

    @Override
    public MessageStatusResponseDTO deleteContactService(String number) {
        return contactRepository.delete(number);
    }

    @Override
    public Boolean existsContactService(String number) {
        return contactRepository.exists(number);
    }
}
