package me.bezgerts.SwaggerDocumentation.service.swagger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;
import v2.io.swagger.models.Swagger;
import v2.io.swagger.parser.SwaggerParser;

import java.util.Map;

@Service
@Transactional
public class SwaggerServiceImpl implements SwaggerService {

    private Swagger getSwagger() {
        Swagger swagger = new SwaggerParser().read("swagger.json");
        return swagger;
    }

    public Map<String, Path> getPaths() {
        return getSwagger().getPaths();
    }

    public Map<String, Model> getDefinitions() {
        return getSwagger().getDefinitions();
    }
}
