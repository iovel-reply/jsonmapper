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
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Offer {

    @JsonProperty("activationDate")
    private String activationDate;
    @JsonProperty("bundles")
    private List<Bundle> bundles = null;
    @JsonProperty("canale")
    private String canale;
    @JsonProperty("categoria")
    private String categoria;
    @JsonProperty("classificazione")
    private String classificazione;
    @JsonProperty("code")
    private String code;
    @JsonProperty("deactivationDate")
    private String deactivationDate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("restart")
    private String restart;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
