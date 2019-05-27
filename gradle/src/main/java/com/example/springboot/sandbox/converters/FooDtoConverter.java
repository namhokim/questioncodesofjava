package com.example.springboot.sandbox.converters;

import com.example.springboot.sandbox.controller.FooDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FooDtoConverter implements Converter<FooDto, String> {
    @Override
    public String convert(FooDto source) {
        System.out.println("Just convert by zipcode");
        return source.getZipcode();
    }
}
