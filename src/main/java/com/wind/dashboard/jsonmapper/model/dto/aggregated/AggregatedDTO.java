package com.wind.dashboard.jsonmapper.model.dto.aggregated;

import com.wind.dashboard.jsonmapper.enums.WidgetType;
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
    private Map<WidgetType, AggregatedWidget> widgets;
}
