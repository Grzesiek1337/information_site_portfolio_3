package com.informations24h.informations24h;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class Informations24hApplication {

	public static void main(String[] args) {
		SpringApplication.run(Informations24hApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
