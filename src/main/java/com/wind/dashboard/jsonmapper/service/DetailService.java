package com.wind.dashboard.jsonmapper.service;

import com.wind.dashboard.jsonmapper.enums.WidgetType;
import com.wind.dashboard.jsonmapper.exception.BadRequestException;
import com.wind.dashboard.jsonmapper.exception.JsonMapperException;
import com.wind.dashboard.jsonmapper.exception.enums.BadRequestErrorCode;
import com.wind.dashboard.jsonmapper.model.dto.input.Bundle;
import com.wind.dashboard.jsonmapper.model.dto.input.Offer;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import com.wind.dashboard.jsonmapper.model.dto.detail.DetailDTO;
import com.wind.dashboard.jsonmapper.model.dto.detail.Header;
import com.wind.dashboard.jsonmapper.model.dto.detail.DetailWidget;
import com.wind.dashboard.jsonmapper.model.DetailWidgetFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DetailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailService.class);
    private static DetailWidgetFactory factory = new DetailWidgetFactory();

    /**
     * @param data
     * @param value
     * @return
     */
    public DetailDTO getDashboard(UserData data, String value) throws JsonMapperException {
        LOGGER.info("//TODO");
        try {
            WidgetType type = WidgetType.valueOf(value.toUpperCase());

            List<DetailWidget> widgets;
            List<Offer> offers = data.getOffers();
            widgets = offers.stream().map(offer -> getWidget(offer, type)).filter(widget -> widget.getTotal() != 0).collect(Collectors.toList());

            Long residual = widgets.stream().mapToLong(widget -> widget.getResidual()).sum();
            Long total = widgets.stream().mapToLong(widget -> widget.getTotal()).sum();

            Header header = new Header(total, residual);

            DetailDTO response = DetailDTO.builder()
                    .header(header)
                    .widgets(widgets).build();

            return response;
        } catch (IllegalArgumentException e) {
            LOGGER.error("//TODO");
            throw new BadRequestException(BadRequestErrorCode.NOT_VALID_WIDGET);
        } catch (Exception e) {
            LOGGER.error("//TODO");
            throw new BadRequestException(BadRequestErrorCode.GENERIC_ERROR);
        }
    }


    /**
     * @param offer
     * @param type
     * @return
     */
    private DetailWidget getWidget(Offer offer, WidgetType type) {
        LOGGER.debug("//TODO");
        DetailWidget widget = factory.create(type);
        widget.setName(offer.getName());

        List<Bundle> bundles = offer.getBundles();
        for (Bundle bundle : bundles) {
            if (type.toString().equalsIgnoreCase(bundle.getValue())) {
                widget.setExpiryDate(bundle.getExpiryDate());
                Long residual = bundle.getResidual();
                Long total = residual + bundle.getAccumulated();
                widget.setResidual(residual);
                widget.setTotal(total);
            }
        }

        widget.setText(widget.getResidual(), widget.getTotal());

        return widget;
    }


}
