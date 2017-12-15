package me.bezgerts.SwaggerDocumentation.controller;

import me.bezgerts.SwaggerDocumentation.service.swagger.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @Autowired
    private SwaggerService swaggerService;



}
