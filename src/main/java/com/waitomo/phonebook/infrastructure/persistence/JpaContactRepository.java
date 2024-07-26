package com.waitomo.phonebook.infrastructure.persistence;

import com.waitomo.phonebook.domain.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaContactRepository extends JpaRepository<ContactEntity,Long>{

    Boolean existsByNumberPhone(String number);

    @Query(value = "SELECT * FROM tb_contact WHERE name LIKE %:value% OR number_phone LIKE %:value%", nativeQuery = true)
    Optional<ContactEntity> findContactByNameOrNumberPhone(@Param("value") String nameOrNumber);
}
