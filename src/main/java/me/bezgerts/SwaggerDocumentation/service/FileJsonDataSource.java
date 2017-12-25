package me.bezgerts.SwaggerDocumentation.service;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;

@Getter
@Setter
@ConfigurationProperties(prefix = "swagger.file")
@Component
public class FileJsonDataSource implements JsonDataSource {

    private String name;

    @Override
    @SneakyThrows
    public String getJson() {
        return new String(Files.readAllBytes(Paths.get(name)));
    }

}
