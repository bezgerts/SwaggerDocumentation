package me.bezgerts.SwaggerDocumentation.service.swagger;

import me.bezgerts.SwaggerDocumentation.domain.SwaggerSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment env;

    private Swagger getSwagger() {

        SwaggerSource swaggerSource = SwaggerSource.valueOf(env.getProperty("swagger.source"));
        Swagger swagger = null;

        switch (swaggerSource) {
            case FILE:
                swagger = new SwaggerParser().read(env.getProperty("swagger.source.file.name"));
                break;

            case HTTP:
                swagger = new SwaggerParser().read(env.getProperty("swagger.source.http.url"));
                break;
        }
        return swagger;
    }

    public Map<String, Path> getPaths() {
        return getSwagger().getPaths();
    }

    public Map<String, Model> getDefinitions() {
        return getSwagger().getDefinitions();
    }
}
