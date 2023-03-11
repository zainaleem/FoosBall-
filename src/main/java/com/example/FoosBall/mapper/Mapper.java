package com.example.FoosBall.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

	@Bean
	public	ModelMapper modelmapper() {
			return new ModelMapper();
		}

}
