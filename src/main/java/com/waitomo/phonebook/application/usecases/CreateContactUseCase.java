package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateContactUseCase {
    @Autowired
    private ContactService contactService;

    public Contact execute(String name,String number){
        Contact contact = new Contact();
        contact.setName(name);
        contact.setNumberPhone(number);

        return contactService.createContactService(contact);
    }
}
