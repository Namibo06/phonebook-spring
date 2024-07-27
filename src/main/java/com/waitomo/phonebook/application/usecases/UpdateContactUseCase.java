package com.waitomo.phonebook.application.usecases;

import com.waitomo.phonebook.application.services.ContactService;
import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.domain.exceptions.NotFoundException;
import com.waitomo.phonebook.domain.exceptions.NullValuesException;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateContactUseCase {
    private final ContactService contactService;

    public UpdateContactUseCase(ContactService contactService, ModelMapper modelMapper) {
        this.contactService = contactService;
    }

    public MessageStatusResponse execute(String number, Contact contact){
        if(!contactService.existsContactService(number)){
            throw new NotFoundException("Contato","o");
        }

        ContactEntity contactEntity = contactService.updateContactService(number, contact);

        if(contactEntity.getId() == null || contactEntity.getName() == null || contactEntity.getNumberPhone() == null){
            throw new NullValuesException("Id/Nome/Número de Telefone nulo(s)");
        }

        final String MESSAGE_UPDATE = "Atualizado com sucesso!";
        final Integer STATUS_UPDATE = 200;
        return new MessageStatusResponse(MESSAGE_UPDATE,STATUS_UPDATE);
    }
}
