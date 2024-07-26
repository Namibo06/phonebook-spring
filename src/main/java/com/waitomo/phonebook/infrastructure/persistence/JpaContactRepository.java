package com.waitomo.phonebook.infrastructure.persistence;

import com.waitomo.phonebook.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaContactRepository extends JpaRepository<ContactEntity,Long>{

    Boolean existsByNumberPhone(String number);
}
