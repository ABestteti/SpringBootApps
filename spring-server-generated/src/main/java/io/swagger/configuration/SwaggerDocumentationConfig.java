package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info()
                .title("Balance Sheet of Assets and Liabilities View")
                .description("This Api provides capabilities to:   - Retrieve the balance sheet of assets and liabilities for a given identifier (bnc_id)")
                .termsOfService("https://customerinformation-development.apis.bngf.local:443")
                .version("3.1")
                .license(new License()
                    .name("NBC Copyright")
                    .url("http://unlicense.org"))
                .contact(new io.swagger.v3.oas.models.info.Contact()
                    .email("mdm.operation@bnc.ca")));
    }

}
