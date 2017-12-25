package me.bezgerts.SwaggerDocumentation.service;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

@Getter
@Setter
@ConfigurationProperties(prefix = "swagger.http")
@Component
public class UrlJsonDataSource implements JsonDataSource {

    private String url;

    @Override
    @SneakyThrows
    public String getJson() {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new URL(url).openStream()))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

}
