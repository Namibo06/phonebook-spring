package com.waitomo.phonebook.infrastructure.persistence.impl;

import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.domain.repositories.ContactRepository;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.persistence.JpaContactRepository;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContactRepositoryImpl implements ContactRepository {

    private final JpaContactRepository jpaContactRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ContactRepositoryImpl(JpaContactRepository jpaContactRepository,ModelMapper modelMapper) {
        this.jpaContactRepository = jpaContactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactEntity save(ContactEntity contact) {
        return jpaContactRepository.save(contact);
    }

    @Override
    public Optional<ContactEntity> findByNameOrNumber(String nameOrNumber) {
        return jpaContactRepository.findContactByNameOrNumberPhone(nameOrNumber);
    }


    @Override
    public Page<ContactResponse> findAllContacts(Pageable pageable) {
        Page<ContactEntity> contactEntities = jpaContactRepository.findAll(pageable);
        Page<ContactResponse> contactResponses = contactEntities.map(contactEntity -> modelMapper.map(contactEntity, ContactResponse.class));

        return contactResponses;
    }

    @Override
    public ContactEntity update(String number, Contact contact) {
        Optional<ContactEntity> contactEntity = jpaContactRepository.findContactByNameOrNumberPhone(number);
        contactEntity.map(contactModel -> {
                    contactModel.setName(contact.getName());
                    contactModel.setNumberPhone(contact.getNumberPhone());
                    return contactModel;
                });

        ContactEntity contactSaved = modelMapper.map(contactEntity,ContactEntity.class);
        jpaContactRepository.save(contactSaved);

        return contactSaved;
    }

    @Override
    public void delete(String number) {
        jpaContactRepository.deleteByNumberPhone(number);
    }

    @Override
    public Boolean exists(String number) {
        return jpaContactRepository.existsByNumberPhone(number);
    }
}
