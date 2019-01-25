package com.wind.dashboard.jsonmapper.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponse {
    public static final String SUCCESS_MESSAGE = "Successful Operation";

    private String code;
    private String type;
    private String message;
    private String detail;

    @Deprecated
    public ApiResponse() {
    }

    /**
     * @param code
     * @param type
     * @param message
     */
    @Deprecated
    public ApiResponse(Integer code, String type, String message) {
        super();
        this.code = Integer.toString(code);
        this.type = type;
        this.message = message;
    }

    /**
     * @param code
     * @param type
     * @param message
     */
    public ApiResponse(String code, String type, String message) {
        super();
        this.code = code;
        this.type = type;
        this.message = message;
    }

    /**
     * @param code
     * @param type
     * @param message
     * @param detail
     */
    public ApiResponse(String code, String type, String message, String detail) {
        super();
        this.code = code;
        this.type = type;
        this.message = message;
        this.detail = detail;
    }
}
