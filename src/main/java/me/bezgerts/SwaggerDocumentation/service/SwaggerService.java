package me.bezgerts.SwaggerDocumentation.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.bezgerts.SwaggerDocumentation.model.SwaggerModel;
import me.bezgerts.SwaggerDocumentation.model.SwaggerModelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;
import v2.io.swagger.models.Swagger;
import v2.io.swagger.parser.SwaggerParser;

import java.util.Date;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class SwaggerService {

    @NonNull
    private final SwaggerModelRepository repository;

    @NonNull
    private final JsonDataSource source;

    public boolean checkSwaggerActuality() {
        // TODO: 20.12.17 реализовать метод 
        String swaggerRemoteJson = source.getJson();
        String swaggerStoredJson = null;
        return false;
    }

    public Map<String, Model> getDefinitions() {
        return getSwagger().getDefinitions();
    }

    public Map<String, Path> getPaths() {
        return getSwagger().getPaths();
    }

    public void saveRemoteSwaggerToDatabase() {
        String swaggerJson = source.getJson();
        SwaggerModel swaggerModel = new SwaggerModel(swaggerJson, new Date());
        repository.save(swaggerModel);
    }

    private String getLatestSwaggerJson() {
        return null;
    }

    private Swagger getSwagger() {
        String swaggerAsString = source.getJson();
        Swagger swagger = new SwaggerParser().parse(swaggerAsString);
        return swagger;
    }

}
