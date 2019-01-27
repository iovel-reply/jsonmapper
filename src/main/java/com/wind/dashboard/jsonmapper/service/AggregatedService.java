package com.wind.dashboard.jsonmapper.service;

import com.wind.dashboard.jsonmapper.enums.ValueTag;
import com.wind.dashboard.jsonmapper.model.dto.input.Bundle;
import com.wind.dashboard.jsonmapper.model.dto.input.Offer;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import com.wind.dashboard.jsonmapper.model.dto.response.aggregated.AggregatedDTO;
import com.wind.dashboard.jsonmapper.model.dto.response.aggregated.Header;
import com.wind.dashboard.jsonmapper.model.dto.response.aggregated.AggregatedWidget;
import com.wind.dashboard.jsonmapper.model.dto.response.AggregatedWidgetFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class AggregatedService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AggregatedService.class);
    private static AggregatedWidgetFactory factory = new AggregatedWidgetFactory();

    /**
     * @param data
     * @return
     */
    public AggregatedDTO getDashboard(UserData data) {
        LOGGER.info("Computing new Aggregated Dashboard");
        Map<ValueTag, AggregatedWidget> widgetMap = initMap();

        List<Offer> offers = data.getOffers();
        for (Offer offer : offers) {
            widgetMap = getWidgets(widgetMap, offer);
        }

        Header header = new Header(data.getMsisdn(), data.getCredit());
        AggregatedDTO response = AggregatedDTO.builder().header(header)
                .widgets(widgetMap).build();

        return response;
    }

    /**
     * @param widgetMap
     * @param offer
     * @return
     */
    private Map<ValueTag, AggregatedWidget> getWidgets(Map<ValueTag, AggregatedWidget> widgetMap, Offer offer) {
        LOGGER.warn("TODO");
        List<Bundle> bundles = offer.getBundles();
        widgetMap.entrySet().stream().forEach(element -> {
            element.setValue(getValues(element.getValue(), element.getKey(), bundles));
        });

        return widgetMap;
    }

    /**
     * @param widget
     * @param tag
     * @param bundles
     * @return
     */
    private AggregatedWidget getValues(AggregatedWidget widget, ValueTag tag, List<Bundle> bundles) {
        LOGGER.warn("TODO");
        Long residual = bundles.stream()
                .filter(bundle -> tag.value().equals(bundle.getValue().toLowerCase()))
                .mapToLong(Bundle::getResidual).sum();
        Long accumulated = bundles.stream()
                .filter(bundle -> tag.value().equals(bundle.getValue().toLowerCase()))
                .mapToLong(Bundle::getAccumulated).sum();

        Long total = widget.getTotal() + residual + accumulated;
        residual += widget.getResidual();

        widget.setTotal(total);
        widget.setResidual(residual);

        return widget;
    }

    /**
     * @return
     */
    private Map<ValueTag, AggregatedWidget> initMap() {
        Map<ValueTag, AggregatedWidget> widgetMap = new HashMap<>();
        Arrays.stream(ValueTag.values()).forEach(tag -> {
            AggregatedWidget widget = factory.getWidget(tag);
            widgetMap.put(tag, widget);
        });

        return widgetMap;
    }

}
