package me.bezgerts.SwaggerDocumentation.controller;

import me.bezgerts.SwaggerDocumentation.domain.SwaggerModel;
import me.bezgerts.SwaggerDocumentation.service.swagger.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;
import v2.io.swagger.models.Swagger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
@RequestMapping(path = "/swagger")
public class SwaggerController {

    @Autowired
    private SwaggerService swaggerService;

    @RequestMapping(path = "/")
    public Swagger getSwagger(){
        return swaggerService.getSwagger();
    }

    @RequestMapping(path = "/paths")
    public Map<String, Path> getPaths() {
        return swaggerService.getPaths();
    }

    @RequestMapping(path = "/definitions")
    public Map<String, Model> getDefinitions() {
        return swaggerService.getDefinitions();
    }

    @RequestMapping(path = "/check")
    public boolean getLatestSwaggerModel() {
        return swaggerService.checkSwaggerActuality();
    }

    @RequestMapping(path = "/save")
    public Swagger saveSwagger() {
        swaggerService.saveSwagger();
        return swaggerService.getSwagger();
    }

}
