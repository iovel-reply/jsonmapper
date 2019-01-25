package com.wind.dashboard.jsonmapper.enums;

public enum ValueTag {

    SMS("SMS"),
    DATA("DATA"),
    VOICE("VOICE");

    private String value;

    public String getName() {
        return this.value;
    }

    public String value() {
        return value;
    }

    ValueTag(final String value) {
        this.value = value;
    }

}
