package com.naver.cafe.javachobostudy.hhs9102.facility;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class FacilityExternal {
    private final RestTemplate restTemplate;

    @Autowired
    public FacilityExternal(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AnimalProtectionFacility> getOrganicAnimalProtectionFacilities() {
        final String uri = "/OrganicAnimalProtectionFacilit?Type=json&SUM_YY=2019&pIndex=1&pSize=100";

        OrganicAnimalProtectionFacilityResponse response =
                restTemplate.getForObject(uri, OrganicAnimalProtectionFacilityResponse.class);
        if (response != null && response.isSuccess()) {
            return response.getAnimalProtectionFacilities();
        }
        return Collections.emptyList();
    }

    @Getter
    @Setter
    public static class OrganicAnimalProtectionFacilityResponse {
        private static final String SUCCESS_CODE = "INFO-000";

        @JsonProperty("OrganicAnimalProtectionFacilit")
        private List<HeadOrRow> reponse;

        public boolean isSuccess() {
            if (reponse == null) {
                return false;
            }
            final Head head = getHead();
            if (head.result == null) {
                return false;
            }
            return SUCCESS_CODE.equals(head.result.code);
        }

        private Head getHead() {
            Head headResponse = new Head();
            for (HeadOrRow headOrRow : reponse) {
                final List<Head> heads = headOrRow.getHeads();
                if (heads == null) {
                    continue;
                }
                for (Head head : heads) {
                    if (head.listTotalCount != null) {
                        headResponse.listTotalCount = head.listTotalCount;
                    }
                    if (head.result != null) {
                        headResponse.result = head.result;
                    }
                    if (head.apiVersion != null) {
                        headResponse.apiVersion = head.apiVersion;
                    }
                }
            }
            return headResponse;
        }

        public List<AnimalProtectionFacility> getAnimalProtectionFacilities() {
            if (reponse == null) {
                return Collections.emptyList();
            }
            for (HeadOrRow headOrRow : reponse) {
                if (headOrRow.getRow() != null) {
                    return headOrRow.getRow();
                }
            }
            return Collections.emptyList();
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @Getter
        @Setter
        public static class HeadOrRow {
            @Nullable
            @JsonProperty("head")
            private List<Head> heads;

            @Nullable
            private List<AnimalProtectionFacility> row;
        }

        @Getter
        @Setter
        static class Head {
            @JsonProperty("list_total_count")
            @Nullable
            private Integer listTotalCount;

            @JsonProperty("RESULT")
            @Nullable
            private FacilitResult result;

            @JsonProperty("api_version")
            @Nullable
            private String apiVersion;

            @Getter
            @Setter
            static class FacilitResult {
                @JsonProperty("CODE")
                private String code;

                @JsonProperty("MESSAGE")
                private String message;
            }
        }
    }

}
