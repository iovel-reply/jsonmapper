package com.wind.dashboard.jsonmapper.model.dto.aggregated;

import com.wind.dashboard.jsonmapper.utils.ConverterUtils;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class SmsWidget implements AggregatedWidget {

    private Long total = 0l;
    private Long residual = 0l;
    private String text;

    @Override
    public Long getTotal() {
        return this.total;
    }

    @Override
    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public Long getResidual() {
        return this.residual;
    }

    @Override
    public void setResidual(Long residual) {
        this.residual = residual;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(Long residual, Long total) {
        StringBuilder text = new StringBuilder();
        text.append(residual)
                .append(" SMS rimasti di ")
                .append(total).append(" SMS");
        this.text = text.toString();
    }
}
