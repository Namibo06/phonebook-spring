package com.waitomo.phonebook.infrastructure.configuration;

import com.waitomo.phonebook.infrastructure.persistence.ContactEntity;
import com.waitomo.phonebook.infrastructure.web.responses.ContactResponse;
import org.hibernate.property.access.spi.Setter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        Converter<ContactEntity, ContactResponse> contactConverter = new Converter<ContactEntity, ContactResponse>() {
            @Override
            public ContactResponse convert(MappingContext<ContactEntity, ContactResponse> context) {
                ContactEntity source = context.getSource();
                return new ContactResponse(source.getName(),source.getNumberPhone());
            }
        };

        modelMapper.addConverter(contactConverter);

        return modelMapper;
    }
}
