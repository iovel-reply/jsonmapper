package com.wind.dashboard.jsonmapper.exception.enums;

public enum BadRequestErrorCode implements ErrorCode {


    GENERIC_ERROR(1,"An error occured, please check request paramters"),

    NOT_VALID_WIDGET(2,"Requested widget doesn't exists"),

    MISSING_USER_DATA(3, "Missing required user data");


    /**
     * The code.
     */
    private Integer code;

    /**
     * The description.
     */
    private String description;


    /**
     * @param code
     * @param description
     */
    private BadRequestErrorCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * @return the code
     */
    @Override
    public String code() {
        return this.name();
    }

    @Override
    public String description() {
        return description;
    }

}