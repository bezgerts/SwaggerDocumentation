package me.bezgerts.SwaggerDocumentation.configuration;

import me.bezgerts.SwaggerDocumentation.service.FileJsonDataSource;
import me.bezgerts.SwaggerDocumentation.service.JsonDataSource;
import me.bezgerts.SwaggerDocumentation.service.UrlJsonDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JsonDataSourceConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(name = "swagger.source", havingValue = "FILE")
    public JsonDataSource fileDataSource() {
        return new FileJsonDataSource();
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "swagger.source", havingValue = "HTTP")
    public JsonDataSource urlDataSource() {
        return new UrlJsonDataSource();
    }

}
