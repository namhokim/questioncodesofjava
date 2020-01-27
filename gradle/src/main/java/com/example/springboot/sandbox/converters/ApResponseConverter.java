package com.example.springboot.sandbox.converters;

import com.example.springboot.sandbox.domain.adg0609.ApResponse;
import com.example.springboot.sandbox.domain.adg0609.ApResponseConvertException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApResponseConverter implements Converter<String, ApResponse> {

    private final ObjectMapper objectMapper;

    public ApResponseConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ApResponse convert(String source) {
        try {
            return objectMapper.readValue(source, ApResponse.class);
        } catch (IOException e) {
            throw new ApResponseConvertException(e);
        }
    }
}
