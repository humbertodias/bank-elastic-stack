package bank.service.account.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .addServersItem(server("http://localhost:3005/account/"))
                .addServersItem(server("http://localhost:8080/"))
                .components(new Components())
                .info(new Info().title("API").description(hostname()));
    }

    private Server server(String url){
        var server = new Server();
        server.setUrl(url);
        return server;
    }

    private String hostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            System.err.println(e);
            return "Unknown";
        }
    }

}
