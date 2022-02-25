package nubank.service.income.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@Profile({"dev", "qa", "test"})
public class SwaggerConfiguration implements WebMvcConfigurer
{


}
