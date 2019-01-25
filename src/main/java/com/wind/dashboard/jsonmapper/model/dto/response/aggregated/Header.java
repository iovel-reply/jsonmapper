package com.wind.dashboard.jsonmapper.model.dto.response.aggregated;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Header {

    private String msisdn;
    private String credit;
}
