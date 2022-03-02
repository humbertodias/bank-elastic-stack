package nubank.service.wallet.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .addServersItem(server("http://localhost:3005"))
                .addServersItem(server("http://localhost:8080"))
                .components(new Components())
                .info(new Info().title("API").description(
                        "Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
    }

    private Server server(String url){
        var server = new Server();
        server.setUrl(url);
        return server;
    }

}
