package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.domain.exceptions.NotFoundException;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class FindContactByNameOrNumberUseCase {
    private final ContactService contactService;
    private final ModelMapper modelMapper;

    @Autowired
    public FindContactByNameOrNumberUseCase(ContactService contactService,ModelMapper modelMapper){
        this.contactService = contactService;
        this.modelMapper = modelMapper;
    }

    public ContactResponse execute(String nameOrNumber){
        if(contactService.findContactByNameOrNumberService(nameOrNumber).isEmpty()){
            throw new NotFoundException("Contato","o");
        }

        Optional<ContactEntity> contact = contactService.findContactByNameOrNumberService(nameOrNumber);
        return modelMapper.map(contact, ContactResponse.class);
    }
}
