package com.waitomo.phonebook.infrastructure.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Agenda Telefônica",description = "API RESTFull de uma Agenda Telefônica com Clean Arquitecture",version = "1.0.0")
)
public class SwaggerConfig {
}
