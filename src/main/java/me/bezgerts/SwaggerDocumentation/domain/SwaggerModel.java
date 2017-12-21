package me.bezgerts.SwaggerDocumentation.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SwaggerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @Lob
    @Column(name = "swagger")
    private String swaggerJson;

    public SwaggerModel() {
    }

    public SwaggerModel(String swaggerJson, Date timestamp) {
        this.timestamp = timestamp;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SwaggerModel{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", swaggerJson='" + swaggerJson + '\'' +
                '}';
    }
}
