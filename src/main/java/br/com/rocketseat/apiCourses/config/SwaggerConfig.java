package br.com.rocketseat.apiCourses.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Courses")
                        .description("Projeto API de cursos")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("Nicoli Fernandes")
                                .url("https://github.com/nic0li")
                                .email("nicoli1992@gmail.com")));
    }

}
