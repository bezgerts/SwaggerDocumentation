package me.bezgerts.SwaggerDocumentation.domain;

import v2.io.swagger.models.Swagger;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SwaggerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @Lob
    @Column(name = "SWAGGER")
    private String swaggerJson;

    public SwaggerModel() {
    }

    public SwaggerModel(String swaggerJson, Date date) {
        this.date = date;
        this.swaggerJson = swaggerJson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSwaggerJson() {
        return swaggerJson;
    }

    public void setSwaggerJson(String swaggerJson) {
        this.swaggerJson = swaggerJson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SwaggerModel{" +
                "id=" + id +
                ", date=" + date +
                ", swaggerJson='" + swaggerJson + '\'' +
                '}';
    }
}
