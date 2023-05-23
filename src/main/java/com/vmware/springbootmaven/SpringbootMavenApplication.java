package com.vmware.springbootmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition( 
	tags = {@Tag(name = "Springboot-Maven Messages API", description = "Sample API for messages")},
    info = @Info(title = "Messages API", version = "0.1-SNAPSHOT", description = "Sample API for messages"),
    servers = {
       @Server(url = "https://springboot-maven-polyglot-demo.tap-next.blah.cloud", description = "TAP"),
       @Server(url = "http://localhost:8080", description = "localhost")
    }
) 

@SpringBootApplication
public class SpringbootMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMavenApplication.class, args);
	}

}
