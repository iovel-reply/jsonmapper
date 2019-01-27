package com.wind.dashboard.jsonmapper.model.dto.detail;

import java.util.Date;

public interface DetailWidget {
    String getName();

    void setName(String name);

    Date getExpiryDate();

    void setExpiryDate(Date expiryDate);

    Long getTotal();

    void setTotal(Long total);

    Long getResidual();

    void setResidual(Long residual);

    String getText();

    void setText(Long residual, Long total);
}
