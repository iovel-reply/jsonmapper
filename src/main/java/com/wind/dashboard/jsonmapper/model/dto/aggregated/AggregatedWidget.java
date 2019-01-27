package com.wind.dashboard.jsonmapper.model.dto.aggregated;

public interface AggregatedWidget {

    Long getTotal();

    void setTotal(Long total);

    Long getResidual();

    void setResidual(Long left);

    String getText();

    void setText(Long residual, Long total);
}
