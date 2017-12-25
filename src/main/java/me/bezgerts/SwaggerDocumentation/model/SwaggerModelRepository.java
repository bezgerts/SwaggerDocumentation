package me.bezgerts.SwaggerDocumentation.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SwaggerModelRepository extends JpaRepository<SwaggerModel, Long> {

    SwaggerModel findTopByOrderByTimestampDesc();
    
}
