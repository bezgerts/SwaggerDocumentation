package me.bezgerts.SwaggerDocumentation.service.swagger;

import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;

import java.util.Map;


public interface SwaggerService {
    Map<String, Path> getPaths();
    Map<String, Model> getDefinitions();
}
