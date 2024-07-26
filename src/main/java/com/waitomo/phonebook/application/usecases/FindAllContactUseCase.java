package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class FindAllContactUseCase {
    private final ContactService contactService;

    @Autowired
    public FindAllContactUseCase(ContactService contactService) {
        this.contactService = contactService;
    }

    public Page<ContactResponse> execute(Pageable pageable){
        return contactService.findAllContactService(pageable);
    }
}
