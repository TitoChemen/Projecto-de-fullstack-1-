package cl.duoc.transporte_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TransporteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransporteServiceApplication.class, args);
	}

}
