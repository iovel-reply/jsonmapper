package com.wind.dashboard.jsonmapper.model;

import com.wind.dashboard.jsonmapper.enums.WidgetType;
import com.wind.dashboard.jsonmapper.model.dto.aggregated.DataWidget;
import com.wind.dashboard.jsonmapper.model.dto.aggregated.SmsWidget;
import com.wind.dashboard.jsonmapper.model.dto.aggregated.VoiceWidget;
import com.wind.dashboard.jsonmapper.model.dto.aggregated.AggregatedWidget;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AggregatedWidgetFactory  implements WidgetAbstractFactory<AggregatedWidget>{

    public AggregatedWidget create(WidgetType tag) {
        AggregatedWidget widget = null;

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
