package dio.primeira_api;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Primeira API com Spring Boot")
                        .version("1.0.0")
                        .description("Essa é uma API simples para cadastro de produtos")
                        .contact(new Contact()
                                .name("Luis Augusto")
                                .email("luisaugustoway@gmail.com")
                                .url("https://linkedin.com/in/luix-guxto")
                        )
                        .license(new License()
                                .name("Open Source")
                        )
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Pagina do github")
                        .url("https://github.com/luix-guxto/primeira_api_springboot")
                );
    }
}
