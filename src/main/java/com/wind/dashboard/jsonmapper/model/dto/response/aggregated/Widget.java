package com.wind.dashboard.jsonmapper.model.dto.response.aggregated;

public interface Widget {

    void setTotal(int total);

    int getTotal();

    void setResidual(int left);

    int getResidual();

    void setText(String text);

    String getText();
}
