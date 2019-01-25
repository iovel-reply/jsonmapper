package com.wind.dashboard.jsonmapper.exception;

public enum ResponseType {
    SUCCESS("SUCCESS"),
    INFO("INFO"),
    WARNING("WARNING"),
    ERROR("ERROR");

    private String value;

    /**
     * @param value
     */
    ResponseType(String value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public String value() {
        return value;
    }

}