package com.wind.dashboard.jsonmapper.enums;

public enum WidgetType {
    SMS("sms"),
    DATA("data"),
    VOICE("voice");

    private String value;

    public String value() {
        return this.value;
    }

    WidgetType(final String value) {
        this.value = value;
    }

}