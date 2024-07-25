package com.waitomo.phonebook.infrastructure.persistence.impl;

import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.domain.repositories.ContactRepository;
import com.waitomo.phonebook.infrastructure.persistence.JpaContactRepository;
import com.waitomo.phonebook.infrastructure.web.dtos.ContactResponseDTO;
import com.waitomo.phonebook.infrastructure.web.dtos.MessageStatusResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContactRepositoryImpl implements ContactRepository {

    private final JpaContactRepository jpaContactRepository;

    @Autowired
    public ContactRepositoryImpl(JpaContactRepository jpaContactRepository) {
        this.jpaContactRepository = jpaContactRepository;
    }

    @Override
    public Contact save(Contact contact) {
        return jpaContactRepository.save(contact);
    }

    @Override
    public Optional<Contact> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Contact> findByNumberPhone(String phone) {
        return Optional.empty();
    }

    @Override
    public Page<ContactResponseDTO> findAll(Pageable pageable) {
        return findAll(pageable);
    }

    @Override
    public MessageStatusResponseDTO update(String number, Contact contact) {
        return null;
    }

    @Override
    public MessageStatusResponseDTO delete(String number) {
        return null;
    }

    @Override
    public Boolean exists(String number) {
        return null;
    }
}
