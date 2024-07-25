package com.waitomo.phonebook.infrastructure.web.controllers;

import com.waitomo.phonebook.application.usecases.CreateContactUseCase;
import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.web.dtos.ContactRequestDTO;
import com.waitomo.phonebook.infrastructure.web.dtos.MessageStatusResponseDTO;
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
    public ResponseEntity<MessageStatusResponseDTO> createContact(@RequestBody @Valid ContactRequestDTO contactRequest, UriComponentsBuilder uriBuilder) {
        Contact contact = createContactUseCase.execute(contactRequest.name(), contactRequest.numberPhone());
        Long contactId = contact.getId();
        URI path = uriBuilder.path("/contacts/{id}").buildAndExpand(contactId).toUri();

        final String MESSAGE_CREATED = "Contato criado";
        final Integer STATUS_CREATED = 201;
        MessageStatusResponseDTO response = new MessageStatusResponseDTO(MESSAGE_CREATED,STATUS_CREATED);

        return ResponseEntity.created(path).body(response);
    }
}
