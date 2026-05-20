package org.serratec.eventos.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Sistema de Eventos Acessiveis")
                        .version("1.0")
                        .description("API para gerenciamento de eventos acessíveis")
                        .contact(new Contact()
                                .name("Wallace Ildefonso")
                                .email("arrobateh@gmail.com")));
    }
}
