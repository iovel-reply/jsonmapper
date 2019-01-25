package com.wind.dashboard.jsonmapper.exception;

import lombok.Getter;

public class JsonMapperException extends Exception {

    private static final long serialVersionUID = -7304125117553589057L;

    @Getter
    private ErrorCode errorCode;

    public JsonMapperException(ErrorCode errorCode) {
        this(errorCode, errorCode.description());
    }

    public JsonMapperException(ErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }

    public JsonMapperException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * Instantiates a new not found exception.
     */
    @Deprecated
    public JsonMapperException() {
        this.errorCode = null;
    }

    /**
     * @param message
     */
    @Deprecated
    public JsonMapperException(String message) {
        super(message);
        this.errorCode = null;
    }
}
