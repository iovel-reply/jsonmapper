package com.wind.dashboard.jsonmapper.model.dto.aggregated;


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
