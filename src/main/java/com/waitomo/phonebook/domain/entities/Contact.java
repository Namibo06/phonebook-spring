package com.waitomo.phonebook.domain.entities;

public class Contact {
    private final String name;
    private final String numberPhone;

    public Contact(String name, String numberPhone) {
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
