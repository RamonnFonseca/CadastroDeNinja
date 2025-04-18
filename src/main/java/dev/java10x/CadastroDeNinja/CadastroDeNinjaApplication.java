package dev.java10x.CadastroDeNinja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroDeNinjaApplication { // coração da aplicação Spring, sempre rodamos por aqui o programa.
	// toda aplicação com Spring estamos trabalhando com rotas ou mapas.

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeNinjaApplication.class, args);
	}

}
