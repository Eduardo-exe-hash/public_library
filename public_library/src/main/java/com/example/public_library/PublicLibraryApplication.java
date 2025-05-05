package com.example.public_library;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@OpenAPIDefinition(
		info = @Info(
				title = "Public Library",
				version = "1.0",
				description = "Project Of Public Library",
				contact = @Contact(
						name = "Eduardo Semeao, Rodrigo Silva",
						email = "eduardosemeao05@gmail.com",
						url = "https://www.publiclibrary.com.br/")


		)
)
@SpringBootApplication
public class PublicLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicLibraryApplication.class, args);
	}

}
