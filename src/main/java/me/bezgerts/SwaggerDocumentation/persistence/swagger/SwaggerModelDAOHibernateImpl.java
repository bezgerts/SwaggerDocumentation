package me.bezgerts.SwaggerDocumentation.persistence.swagger;

import me.bezgerts.SwaggerDocumentation.domain.SwaggerModel;
import me.bezgerts.SwaggerDocumentation.persistence.GenericDaoHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class SwaggerModelDAOHibernateImpl extends GenericDaoHibernateImpl<SwaggerModel, Long> implements SwaggerModelDAO {
    @Override
    public SwaggerModel getLatestSwaggerJsonByTimestamp() {
        return null;
    }
}
