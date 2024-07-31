package com.waitomo.phonebook.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30,nullable = false)
    private String name;

    @Column(name = "number_phone",unique = true,columnDefinition = "CHAR(11)",nullable = false)
    private String numberPhone;

    public ContactEntity() {

    }

    public ContactEntity(Long id, String name, String numberPhone) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
