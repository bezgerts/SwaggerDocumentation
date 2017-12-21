package me.bezgerts.SwaggerDocumentation.service.swagger;

import me.bezgerts.SwaggerDocumentation.domain.SwaggerModel;
import me.bezgerts.SwaggerDocumentation.domain.SwaggerSource;
import me.bezgerts.SwaggerDocumentation.persistence.GenericDAO;
import me.bezgerts.SwaggerDocumentation.persistence.swagger.SwaggerModelDAO;
import me.bezgerts.SwaggerDocumentation.service.GenericServiceImpl;
import me.bezgerts.SwaggerDocumentation.util.FileUtils;
import me.bezgerts.SwaggerDocumentation.util.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.io.swagger.models.Model;
import v2.io.swagger.models.Path;
import v2.io.swagger.models.Swagger;
import v2.io.swagger.parser.SwaggerParser;

import java.util.Date;
import java.util.Map;

@Service
@Transactional
public class SwaggerServiceImpl extends GenericServiceImpl<SwaggerModel, Long> implements SwaggerService {

    @Autowired
    private Environment env;

    private SwaggerModelDAO swaggerModelDAO;

    @Autowired
    public SwaggerServiceImpl(@Qualifier("swaggerModelDAOHibernateImpl") GenericDAO<SwaggerModel, Long> genericDAO) {
        super(genericDAO);
        this.swaggerModelDAO = (SwaggerModelDAO) genericDAO;
    }

    public Swagger getSwagger() {
        String swaggerAsString = swaggerModelDAO.getLatestSwaggerModelByTimestamp().getSwaggerJson();
        Swagger swagger = new SwaggerParser().parse(swaggerAsString);
        return swagger;
    }

    public boolean checkSwaggerActuality() {
        String swaggerRemoteJson = getSwaggerJsonFromRemote();
        String swaggerStoredJson = swaggerModelDAO.getLatestSwaggerModelByTimestamp().getSwaggerJson();
        if (swaggerRemoteJson.equals(swaggerStoredJson)) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Path> getPaths() {
        return getSwagger().getPaths();
    }

    public Map<String, Model> getDefinitions() {
        return getSwagger().getDefinitions();
    }

    @Override
    public void saveSwagger() {
        String swaggerJson = getSwaggerJsonFromRemote();
        SwaggerModel swaggerModel = new SwaggerModel(swaggerJson, new Date());
        swaggerModelDAO.add(swaggerModel);
    }

    private String getSwaggerJsonFromRemote(){
        SwaggerSource swaggerSource = SwaggerSource.valueOf(env.getProperty("swagger.source"));
        String swaggerJson = null;
        switch (swaggerSource) {
            case FILE:
                swaggerJson = FileUtils.readFromFile(env.getProperty("swagger.source.file.name"));
                break;

            case HTTP:
                swaggerJson = HttpUtils.sendGetRequest(env.getProperty("swagger.source.http.url"));
                break;
        }
        return swaggerJson;
    }
}
