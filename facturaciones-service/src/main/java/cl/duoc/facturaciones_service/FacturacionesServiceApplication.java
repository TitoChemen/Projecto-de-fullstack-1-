package cl.duoc.facturaciones_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FacturacionesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturacionesServiceApplication.class, args);
	}

}
