package com.waitomo.phonebook.infrastructure.web.responses;

import com.waitomo.phonebook.domain.entities.Contact;

public class MessageStatusResponse {
    private final String message;
    private final Integer status;

    public MessageStatusResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }
}
