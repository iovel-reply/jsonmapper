package com.wind.dashboard.jsonmapper.service;

import com.wind.dashboard.jsonmapper.enums.ValueTag;
import com.wind.dashboard.jsonmapper.model.dto.input.Bundle;
import com.wind.dashboard.jsonmapper.model.dto.input.Offer;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import com.wind.dashboard.jsonmapper.model.dto.response.aggregated.AggregatedResponse;
import com.wind.dashboard.jsonmapper.model.dto.response.aggregated.Widget;
import com.wind.dashboard.jsonmapper.model.dto.response.aggregated.WidgetFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AggregatedDashboardService {
    private static WidgetFactory factory = new WidgetFactory();

    public AggregatedResponse getDashboard(UserData data) {

        Widget dataWidget = factory.getWidget(ValueTag.DATA);
        Widget smsWidget = factory.getWidget(ValueTag.SMS);
        Widget voiceWidget = factory.getWidget(ValueTag.VOICE);

        List<Offer> offers = data.getOffers();

        for (Offer offer: offers) {
            //TODO
        }

        return null;
    }

    private List<Widget> getWidgets(List<Offer> offers) {


        for (Offer offer : offers) {


        }

        return null;
    }


    /**
     * @param bundles
     * @return
     */
    private List<Widget> loopOnBundles(Map<ValueTag, Widget> widgetMap, List<Bundle> bundles) {



        return null;
    }

    /**
     * @param tag
     * @param bundles
     * @return
     */
    private Widget getValues(ValueTag tag, List<Bundle> bundles) {

        Widget widget = factory.getWidget(tag);
        Integer residual = bundles.stream()
                .filter(bundle -> tag.value().equals(bundle.getValue().toUpperCase()))
                .mapToInt(Bundle::getResidual).sum();
        Integer accumulated = bundles.stream()
                .filter(bundle -> tag.value().equals(bundle.getValue().toUpperCase()))
                .mapToInt(Bundle::getAccumulated).sum();

        widget.setTotal(residual + accumulated);
        widget.setResidual(residual);

        return widget;
    }
}
