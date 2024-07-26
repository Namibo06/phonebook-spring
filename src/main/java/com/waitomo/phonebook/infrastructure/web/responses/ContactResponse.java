package com.waitomo.phonebook.infrastructure.web.responses;

public class ContactResponse{
    private final String name;
    private final String numberPhone;

    public ContactResponse(String name, String numberPhone) {
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }
}
