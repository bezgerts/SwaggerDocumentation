package me.bezgerts.SwaggerDocumentation.controller;

import me.bezgerts.SwaggerDocumentation.service.swagger.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SwaggerController {

    @Autowired
    private SwaggerService swaggerService;

    @RequestMapping(path = "/paths")
    public List<String> getPaths() {
        return swaggerService.getPaths();
    }

}
