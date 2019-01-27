package com.wind.dashboard.jsonmapper.model.dto.response;


import com.wind.dashboard.jsonmapper.enums.WidgetType;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.DataWidget;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.DetailWidget;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.SmsWidget;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.VoiceWidget;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DetailWidgetFactory implements WidgetAbstractFactory<DetailWidget> {

    public DetailWidget create(WidgetType type) {
        DetailWidget widget = null;

        switch (type) {
            case SMS:
                widget = new SmsWidget();
                break;
            case DATA:
                widget = new DataWidget();
                break;
            case VOICE:
                widget = new VoiceWidget();
                break;
            default:
                //TODO
        }

        return widget;
    }
}
