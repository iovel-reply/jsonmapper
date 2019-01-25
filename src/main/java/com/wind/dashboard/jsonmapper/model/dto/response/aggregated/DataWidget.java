package com.wind.dashboard.jsonmapper.model.dto.response.aggregated;


import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class DataWidget implements Widget {

    private int total;
    private int residual;
    private String text;

    @Override
    public void setTotal(int total) { this.total = total; }

    @Override
    public int getTotal() {
        return this.total;
    }

    @Override
    public void setResidual(int residual) {
        this.residual = residual;
    }

    @Override
    public int getResidual() {
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
