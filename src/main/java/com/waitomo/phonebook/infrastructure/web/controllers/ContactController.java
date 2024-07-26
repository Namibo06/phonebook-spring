package com.waitomo.phonebook.infrastructure.web.controllers;

import com.waitomo.phonebook.application.mapper.ContactMapper;
import com.waitomo.phonebook.application.usecases.CreateContactUseCase;
import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private CreateContactUseCase createContactUseCase;

    @PostMapping
    public ResponseEntity<MessageStatusResponse> createContact(@RequestBody @Valid Contact contactRequest, UriComponentsBuilder uriBuilder) {
        ContactEntity contact = createContactUseCase.execute(ContactMapper.toEntity(contactRequest));
        Long contactId = contact.getId();
        URI path = uriBuilder.path("/contacts/{id}").buildAndExpand(contactId).toUri();

        final String MESSAGE_CREATED = "Contato criado";
        final Integer STATUS_CREATED = 201;
        MessageStatusResponse response = new MessageStatusResponse(MESSAGE_CREATED,STATUS_CREATED);

        return ResponseEntity.created(path).body(response);
    }
}
