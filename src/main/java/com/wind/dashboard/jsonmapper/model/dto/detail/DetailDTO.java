package com.wind.dashboard.jsonmapper.model.dto.detail;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class DetailDTO {
    private Header header;
    private List<DetailWidget> widgets;
}
