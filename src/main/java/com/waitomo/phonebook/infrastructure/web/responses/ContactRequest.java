package com.waitomo.phonebook.infrastructure.web.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

public class ContactRequest {
        private String name;
        private String phoneNumber;

        public ContactRequest() {}

        public ContactRequest(String name, String phoneNumber) {
                //colocar verificações para valid
                if(name.isBlank() || phoneNumber.isBlank()){
                        throw new RuntimeException("Valores em branco não permitido");
                }
                if(name.length() < 3 || name.length() > 30){
                        throw new RuntimeException("Nome deve ter entre 3 e 30 caracteres");
                }

                if(phoneNumber.length() != 11){
                        throw new RuntimeException("Um número do formato (99) 9 9999-9999 deve conter 11 números");
                }

                this.name = name;
                this.phoneNumber = phoneNumber;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }
}
