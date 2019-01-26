package com.wind.dashboard.jsonmapper.exception;

import com.wind.dashboard.jsonmapper.exception.enums.ErrorCode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FeignErrorCode implements ErrorCode {

    private String description;

    private String code;

    @Override
    public String code() {

        return code;
    }

    @Override
    public String description() {
        return description;
    }
}