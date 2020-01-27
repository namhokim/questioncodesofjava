package com.example.springboot.sandbox.converters;

import com.example.springboot.sandbox.domain.adg0609.PageConverterException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PageConverter implements Converter<String, Integer[]> {

    private final ObjectMapper objectMapper;

    public PageConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Integer[] convert(String source) {
        try {
            return objectMapper.readValue(source, Integer[].class);
        } catch (IOException e) {
            throw new PageConverterException(e);
        }
    }
}
