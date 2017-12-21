package me.bezgerts.SwaggerDocumentation.persistence.swagger;

import me.bezgerts.SwaggerDocumentation.domain.SwaggerModel;
import me.bezgerts.SwaggerDocumentation.persistence.GenericDaoHibernateImpl;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

@Repository
public class SwaggerModelDAOHibernateImpl extends GenericDaoHibernateImpl<SwaggerModel, Long> implements SwaggerModelDAO {
    @Override
    public SwaggerModel getLatestSwaggerModelByTimestamp() {
        SwaggerModel swaggerModel = (SwaggerModel) currentSession()
                .createCriteria(SwaggerModel.class)
                .addOrder(Order.desc("timestamp"))
                .setMaxResults(1)
                .uniqueResult();
        return swaggerModel;
    }
}
