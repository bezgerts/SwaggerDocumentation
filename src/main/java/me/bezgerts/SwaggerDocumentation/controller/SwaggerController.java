package me.bezgerts.SwaggerDocumentation.controller;

import me.bezgerts.SwaggerDocumentation.service.swagger.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;

import java.util.Map;

@RestController
public class SwaggerController {

    @Autowired
    private SwaggerService swaggerService;

    @RequestMapping(path = "/paths")
    public Map<String, Path> getPaths() {
        return swaggerService.getPaths();
    }

    @RequestMapping(path = "/definitions")
    public Map<String, Model> getDefinitions() {
        return swaggerService.getDefinitions();
    }

}
