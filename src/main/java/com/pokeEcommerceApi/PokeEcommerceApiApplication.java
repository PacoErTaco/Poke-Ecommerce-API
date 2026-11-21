package com.pokeEcommerceApi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PokeEcommerceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeEcommerceApiApplication.class, args);
	}

	@Bean
	CommandLineRunner apiEndpoints(Environment environment) {		
		return args -> {
			String port = environment.getProperty("local.server.port", "8080");
			String baseUrl = "http://localhost:" + port;
			
			String martEndpoint = baseUrl + "/pokemart";
			String trainerEndpoint = baseUrl + "/trainer";
			String objectEndpoint = baseUrl + "/object";
			String orderEndpoint = baseUrl + "/order";
			String orderItemEndpoint = baseUrl + "/orderItem";
			
			String banner = """
			        ======================================================================
			        	¡POKE E-COMMERCE API DESPLEGADA CON ÉXITO!
			        ----------------------------------------------------------------------
			         URL principal: %s
			        ----------------------------------------------------------------------
			         Endpoints disponibles:
			         	
			         	· Tiendas (Poké marts) -> %s
			         	
			         	· Entrenadores (Trainer card) -> %s
			         	
			         	· Productos (Objects) -> %s
			         	
			         	· Pedidos (Orders) -> %s
			        	
			        	· Detalles de pedido (Order items) -> %s
			        ======================================================================
			        """.formatted(baseUrl, martEndpoint, trainerEndpoint, objectEndpoint, orderEndpoint, orderItemEndpoint);
			
			System.out.println(banner);
		};
	}
	
}
