package com.naver.cafe.javachobostudy.hhs9102.facility;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriTemplateHandler;

import java.util.Collections;
import java.util.List;

public class FacilityExternalTester {
    private static final String URL = "https://openapi.gg.go.kr/";

    public static void main(String[] args) {
        FacilityExternalTester config = new FacilityExternalTester();
        FacilityExternal facilityExternal = new FacilityExternal(config.restTemplate());
        final List<AnimalProtectionFacility> organicAnimalProtectionFacilities =
                facilityExternal.getOrganicAnimalProtectionFacilities();
        for (AnimalProtectionFacility facility : organicAnimalProtectionFacilities) {
            System.out.println(facility);
        }
    }

    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        UriTemplateHandler uriTemplateHandler = new DefaultUriBuilderFactory(URL);
        restTemplate.setUriTemplateHandler(uriTemplateHandler);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;
    }
}
