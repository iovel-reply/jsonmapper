package com.wind.dashboard.jsonmapper.enums;

public enum ValueTag {

    SMS("sms"),
    DATA("data"),
    VOICE("voice");

    private String value;

    public String value() {
        return this.value;
    }

    ValueTag(final String value) {
        this.value = value;
    }

}
