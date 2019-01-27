package com.wind.dashboard.jsonmapper.model.dto.detail;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VoiceWidget implements DetailWidget {
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date expiryDate;
    private Long residual = 0l;
    private Long total = 0l;
    private String text;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getExpiryDate() {
        return this.expiryDate;
    }

    @Override
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

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
    public void setText(String text) {
        this.text = text;
    }

}