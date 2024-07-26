package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsContactUseCase {
    private final ContactService contactService;

    @Autowired
    public ExistsContactUseCase(ContactService contactService) {
        this.contactService = contactService;
    }

    public Boolean execute(String number){
        return contactService.existsContactService(number);
    }
}
