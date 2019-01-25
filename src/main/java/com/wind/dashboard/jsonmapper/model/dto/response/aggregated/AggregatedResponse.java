package com.wind.dashboard.jsonmapper.model.dto.response.aggregated;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class AggregatedResponse {
    private Header header;
    private List<Widget> widgets;
}
