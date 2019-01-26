package com.wind.dashboard.jsonmapper.model.dto.response.detail;


import com.wind.dashboard.jsonmapper.enums.ValueTag;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WidgetFactory {

    public Widget getWidget(ValueTag tag) {
        Widget widget = null;

        switch (tag) {
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
