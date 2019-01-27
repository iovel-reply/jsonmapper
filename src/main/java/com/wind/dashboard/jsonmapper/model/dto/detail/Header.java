package com.wind.dashboard.jsonmapper.model.dto.detail;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Header {

    private Long total;
    private Long residual;
}
