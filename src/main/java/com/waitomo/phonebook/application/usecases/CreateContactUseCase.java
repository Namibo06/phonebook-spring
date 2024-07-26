package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.exceptions.AlreadyExistsException;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateContactUseCase {
    @Autowired
    private ContactService contactService;

    public ContactEntity execute(ContactEntity contact){
        if(contactService.existsContactService(contact.getNumberPhone())){
            throw new AlreadyExistsException("Número");
        }
        ContactEntity contactUseCase = new ContactEntity();
        contactUseCase.setName(contact.getName());
        contactUseCase.setNumberPhone(contact.getNumberPhone());

        return contactService.createContactService(contactUseCase);
    }
}
