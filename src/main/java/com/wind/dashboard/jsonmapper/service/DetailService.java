package com.wind.dashboard.jsonmapper.service;

import com.wind.dashboard.jsonmapper.enums.ValueTag;
import com.wind.dashboard.jsonmapper.exception.BadRequestException;
import com.wind.dashboard.jsonmapper.exception.JsonMapperException;
import com.wind.dashboard.jsonmapper.exception.enums.BadRequestErrorCode;
import com.wind.dashboard.jsonmapper.model.dto.input.Bundle;
import com.wind.dashboard.jsonmapper.model.dto.input.Offer;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.DetailDTO;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.Header;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.DetailWidget;
import com.wind.dashboard.jsonmapper.model.dto.response.DetailWidgetFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            ValueTag tag = ValueTag.valueOf(value.toUpperCase());

            List<DetailWidget> widgets = new ArrayList<>();
            List<Offer> offers = data.getOffers();
            for (Offer offer : offers) {
                DetailWidget widget = getWidget(offer, tag);
                if (widget.getTotal() != 0) {
                    widgets.add(widget);
                }
            }

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
     * @param tag
     * @return
     */
    private DetailWidget getWidget(Offer offer, ValueTag tag) {
        LOGGER.debug("//TODO");
        DetailWidget widget = factory.getWidget(tag);
        widget.setName(offer.getName());

        List<Bundle> bundles = offer.getBundles();
        bundles.stream().filter(bundle -> tag.value().equals(bundle.getValue().toLowerCase())).forEach(bundle -> {
            widget.setExpiryDate(bundle.getExpiryDate());
            Long residual = bundle.getResidual();
            Long total = residual + bundle.getAccumulated();
            widget.setResidual(residual);
            widget.setTotal(total);
        });

        return widget;
    }


}
