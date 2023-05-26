package com.vmware.springbootmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition( 
	tags = {@Tag(name = "Springboot-Maven Messages API", 
                 description = "An API for obtaining a list of messages")},
    info = @Info(title = "Messages API", version = "0.1-SNAPSHOT", 
                 description = "A simple Messages API designed to return a list of messages that can originate from inside the code or the configuration."),
    servers = {
       @Server(url = "https://springboot-maven-polyglot-demo.tap-next.blah.cloud/api", description = "Spring"),
       @Server(url = "https://node-express-polyglot-demo.tap-next.blah.cloud/api", description = "NodeJS"),
       @Server(url = "http://localhost:8080/api", description = "Local")
    }
) 

@SpringBootApplication
public class SpringbootMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMavenApplication.class, args);
	}

}
