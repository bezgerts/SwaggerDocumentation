package me.bezgerts.SwaggerDocumentation.service.swagger;

import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;
import v2.io.swagger.models.Swagger;

import java.util.Map;


public interface SwaggerService {
    Swagger getSwagger();
    boolean checkSwaggerActuality();
    void saveSwagger();
    Map<String, Path> getPaths();
    Map<String, Model> getDefinitions();
}
