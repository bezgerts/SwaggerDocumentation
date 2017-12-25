package me.bezgerts.SwaggerDocumentation.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class SwaggerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "swagger")
    private String swaggerJson;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public SwaggerModel(String swaggerJson, Date timestamp) {
        this.timestamp = timestamp;
        this.swaggerJson = swaggerJson;
    }

}
