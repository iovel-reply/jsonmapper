package com.wind.dashboard.jsonmapper.model.dto.response.aggregated;

public interface AggregatedWidget {

    void setTotal(Long total);

    Long getTotal();

    void setResidual(Long left);

    Long getResidual();

    void setText(String text);

    String getText();
}