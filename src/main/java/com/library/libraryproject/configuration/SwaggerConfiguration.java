package com.library.libraryproject.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket api(){
        Predicate<RequestHandler> basePackage = RequestHandlerSelectors.basePackage("com.library.libraryproject");
        Predicate<String> apiUrls = PathSelectors.ant("/v1/**");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage)
                .paths(apiUrls)
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MecLibrary",
                "API RestFull para o gerenciamento de bibliotecas",
                "v1",
                "Termos de uso",
                new Contact("Gabriel Faria", "Link da aplicação", "https://meclibrary.com.br"),
                "Licenças da API", "URL de Licenças da API", Collections.emptyList()
        );
    }
}
