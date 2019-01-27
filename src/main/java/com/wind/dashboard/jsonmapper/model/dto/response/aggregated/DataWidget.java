package com.wind.dashboard.jsonmapper.model.dto.response.aggregated;


import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class DataWidget implements AggregatedWidget {

    private Long total = 0l;
    private Long residual = 0l;
    private String text;

    @Override
    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public Long getTotal() {
        return this.total;
    }

    @Override
    public void setResidual(Long residual) {
        this.residual = residual;
    }

    @Override
    public Long getResidual() {
        return this.residual;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
