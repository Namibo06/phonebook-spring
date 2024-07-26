package com.waitomo.phonebook.infrastructure.web.controllers;

import com.waitomo.phonebook.application.mapper.ContactMapper;
import com.waitomo.phonebook.application.usecases.CreateContactUseCase;
import com.waitomo.phonebook.application.usecases.FindAllContactUseCase;
import com.waitomo.phonebook.application.usecases.FindContactByNameOrNumberUseCase;
import com.waitomo.phonebook.domain.entities.Contact;
import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import com.waitomo.phonebook.infrastructure.web.responses.MessageStatusResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@RestController
@RequestMapping("/contacts")
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class ContactController {
    @Autowired
    private CreateContactUseCase createContactUseCase;

    @Autowired
    private FindAllContactUseCase findAllContactUseCase;

    @Autowired
    private FindContactByNameOrNumberUseCase findContactByNameOrNumberUseCase;

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

    @GetMapping
    public ResponseEntity<Page<ContactResponse>> findAllContacts(@PageableDefault(size = 50) Pageable pageable){
        Page<ContactResponse> contactsPage = findAllContactUseCase.execute(pageable);

        return ResponseEntity.ok(contactsPage);
    }

    @GetMapping("/{nameOrNumber}")
    public ResponseEntity<ContactResponse> findContactByNameOrNumber(@PathVariable String nameOrNumber){
        ContactResponse contact = findContactByNameOrNumberUseCase.execute(nameOrNumber);

        return ResponseEntity.ok(contact);
    }
}
