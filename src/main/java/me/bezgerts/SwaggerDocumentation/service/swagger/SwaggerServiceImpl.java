package me.bezgerts.SwaggerDocumentation.service.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.io.swagger.models.Swagger;
import v2.io.swagger.parser.SwaggerParser;

import java.util.ArrayList;
import java.util.List;

import static org.codehaus.groovy.tools.shell.util.Logger.io;

@Service
@Transactional
public class SwaggerServiceImpl implements SwaggerService {

    private Swagger getSwagger() {
        Swagger swagger = new SwaggerParser().read("swagger.json");
        return swagger;
    }

    public List<String> getPaths() {
        return new ArrayList<>(getSwagger().getPaths().keySet());
    }
}
