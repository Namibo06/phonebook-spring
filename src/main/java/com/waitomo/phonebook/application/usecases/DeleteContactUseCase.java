package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.exceptions.NotFoundException;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import org.springframework.stereotype.Component;

@Component
public class DeleteContactUseCase {
    private final ContactService contactService;

    public DeleteContactUseCase(ContactService contactService){
        this.contactService = contactService;
    }

    public void execute(String number){
        if(!contactService.existsContactService(number)){
            throw new NotFoundException("Contato","o");
        }

        contactService.deleteContactService(number);
    }
}
