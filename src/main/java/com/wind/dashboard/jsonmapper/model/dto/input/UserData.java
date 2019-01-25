package com.wind.dashboard.jsonmapper.model.dto.input;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserData {


        @JsonProperty("credit")
        private String credit;
        @JsonProperty("isSuccessful")
        private boolean isSuccessful;
        @JsonProperty("lastRechargeDate")
        private String lastRechargeDate;
        @JsonProperty("msisdn")
        private String msisdn;
        @JsonProperty("offers")
        private List<Offer> offers = null;
        @JsonProperty("response")
        private Response response;
        @JsonProperty("simExpiryDate")
        private String simExpiryDate;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
