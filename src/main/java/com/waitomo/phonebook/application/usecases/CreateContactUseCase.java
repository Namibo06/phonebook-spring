package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CreateContactUseCase {
    @Autowired
    private ContactService contactService;

    private static final Logger log = LoggerFactory.getLogger(CreateContactUseCase.class);

    public Contact execute(String name,String number){
        Contact contact = new Contact();
        contact.setName(name);
        contact.setNumberPhone(number);

        return contactService.createContactService(contact);
    }
}
