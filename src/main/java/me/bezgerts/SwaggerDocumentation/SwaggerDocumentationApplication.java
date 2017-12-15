package me.bezgerts.SwaggerDocumentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class SwaggerDocumentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDocumentationApplication.class, args);
	}
}
