package com.wind.dashboard.jsonmapper.model;

import com.wind.dashboard.jsonmapper.enums.WidgetType;

public interface WidgetAbstractFactory <T> {
    T create(WidgetType widgetType) ;
}
