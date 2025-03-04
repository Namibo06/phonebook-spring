package com.waitomo.phonebook.application.mapper;

import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;

public class ContactMapper {
    public static Contact toDomain(ContactEntity contactEntity){
        return new Contact(
                contactEntity.getName(),
                contactEntity.getNumberPhone()
        );
    }

    public static ContactEntity toEntity(Contact contact){
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setName(contact.getName());
        contactEntity.setNumberPhone(contact.getNumberPhone());
        return contactEntity;
    }
}
