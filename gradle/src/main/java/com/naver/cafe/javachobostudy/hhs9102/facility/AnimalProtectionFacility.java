package com.naver.cafe.javachobostudy.hhs9102.facility;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnimalProtectionFacility {
    @JsonProperty("SUM_YY")
    private String sumYy;
    @JsonProperty("SIGUN_NM")
    private String sigunName;
    @JsonProperty("SIGUN_CD")
    private String sigunCode;
    @JsonProperty("ENTRPS_NM")
    private String enterpriseName;
    @JsonProperty("REPRSNTV_NM")
    private String representativeName;
    @JsonProperty("ACEPTNC_ABLTY_CNT")
    private String acceptanceAbilityCount;
    @JsonProperty("ENTRPS_TELNO")
    private String enterpriseTelephoneNumber;
    @JsonProperty("CONTRACT_PERD")
    private String contractPerd;
    @JsonProperty("CORPR_ANIMAL_HOSPTL_DTLS")
    private String corprAnimalHosptlDtls;
    @JsonProperty("RM_MATR")
    private String rmMatr;
    @JsonProperty("REFINE_LOTNO_ADDR")
    private String refineLotnumberAddress;
    @JsonProperty("REFINE_ROADNM_ADDR")
    private String refineRoadnameAddress;
    @JsonProperty("REFINE_ZIP_CD")
    private String refineZipCode;
    @JsonProperty("REFINE_WGS84_LOGT")
    private String refineWgs84Longitude;
    @JsonProperty("REFINE_WGS84_LAT")
    private String refineWgs84Latitude;
}
