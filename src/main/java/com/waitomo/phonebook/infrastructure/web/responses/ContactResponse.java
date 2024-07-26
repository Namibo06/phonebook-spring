package com.waitomo.phonebook.infrastructure.web.responses;

import com.waitomo.phonebook.domain.entities.Contact;

public class ContactResponse extends Contact {
    private final Long id;

    public ContactResponse(Long id,String name, String numberPhone) {
        super(name,numberPhone);
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}
