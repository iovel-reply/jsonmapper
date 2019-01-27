package com.wind.dashboard.jsonmapper.service;

import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import com.wind.dashboard.jsonmapper.model.FactoryProvider;
import com.wind.dashboard.jsonmapper.model.WidgetAbstractFactory;
import com.wind.dashboard.jsonmapper.model.dto.aggregated.AggregatedDTO;
import com.wind.dashboard.jsonmapper.model.dto.detail.DetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DashboardService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardService.class);

    /**
     *
     * @param data
     * @return
     */
    public AggregatedDTO getDashboard(UserData data) {
        WidgetAbstractFactory aggregated = FactoryProvider.getFactory("aggregated");

        return null;
    }

    /**
     *
     * @param data
     * @param type
     * @return
     */
    public DetailDTO getDashboard(UserData data, String type) {
        WidgetAbstractFactory aggregated = FactoryProvider.getFactory("detail");

        return null;
    }
}
