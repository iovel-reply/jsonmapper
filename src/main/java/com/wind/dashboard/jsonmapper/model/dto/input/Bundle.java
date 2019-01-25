package com.wind.dashboard.jsonmapper.model.dto.input;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bundle {

    @JsonProperty("accumulated")
    private Integer accumulated;
    @JsonProperty("expiryDate")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date expiryDate;
    @JsonProperty("grouping")
    private String grouping;
    @JsonProperty("renewalDate")
    @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date renewalDate;
    @JsonProperty("residual")
    private Integer residual;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}