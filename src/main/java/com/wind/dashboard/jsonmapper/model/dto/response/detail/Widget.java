package com.wind.dashboard.jsonmapper.model.dto.response.detail;

import java.util.Date;

public interface Widget {
    String getName();

    void setName(String name);

    Date getExpiryDate();

    void setExpiryDate(Date expiryDate);

    Long getTotal();

    void setTotal(Long total);

    Long getResidual();

    void setResidual(Long residual);

    String getText();

    void setText(String text);
}
