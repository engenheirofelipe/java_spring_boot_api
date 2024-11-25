package br.com.fiap.consumoapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.consumoapi.principal.Principal;

@SpringBootApplication
public class ConsumoApiApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(ConsumoApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Principal principal = new Principal();
		principal.exibeMenu();
		

		
	}

	
}
