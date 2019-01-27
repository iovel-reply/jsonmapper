package com.wind.dashboard.jsonmapper.model.dto.response.aggregated;

import com.wind.dashboard.jsonmapper.enums.ValueTag;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class AggregatedDTO {
    private Header header;
    private Map<ValueTag, AggregatedWidget> widgets;
}
