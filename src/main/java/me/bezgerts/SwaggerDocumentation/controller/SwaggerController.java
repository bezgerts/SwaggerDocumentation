package me.bezgerts.SwaggerDocumentation.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.bezgerts.SwaggerDocumentation.service.SwaggerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class SwaggerController {

    @NonNull
    private SwaggerService swaggerService;

    @GetMapping(path = "/definitions")
    public Map<String, Model> getDefinitions() {
        return swaggerService.getDefinitions();
    }

    @GetMapping(path = "/paths")
    public Map<String, Path> getPaths() {
        swaggerService.saveRemoteSwaggerToDatabase();
        return swaggerService.getPaths();
    }

}
