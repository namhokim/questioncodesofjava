package com.example.springboot.sandbox.configure.converter;

import com.example.springboot.sandbox.converters.FooDtoConverter;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//@Configuration
public class ConverterConfig {
    @Bean
    public FooDtoConverter fooDtoConverter() {
        return new FooDtoConverter();
    }
}
