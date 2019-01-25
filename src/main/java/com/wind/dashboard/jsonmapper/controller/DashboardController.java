package com.wind.dashboard.jsonmapper.controller;


import com.wind.dashboard.jsonmapper.exception.JsonMapperException;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import com.wind.dashboard.jsonmapper.model.dto.response.aggregated.AggregatedResponse;
import com.wind.dashboard.jsonmapper.model.dto.response.detail.DetailResponse;
import com.wind.dashboard.jsonmapper.service.AggregatedDashboardService;
import com.wind.dashboard.jsonmapper.service.DetailDashboardService;
import com.wind.dashboard.jsonmapper.service.UserDataRetrievalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    AggregatedDashboardService aggregatedDashboardService;

    @Autowired
    DetailDashboardService detailDashboardService;

    @Autowired
    UserDataRetrievalService userDataRetrievalService;

    @RequestMapping(path = "/aggregated", method = RequestMethod.GET)
    public ResponseEntity<AggregatedResponse> getAggregatedDashboard() throws JsonMapperException {

        UserData data = userDataRetrievalService.retrieveUserData();


        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(path = "/details", method = RequestMethod.GET)
    public ResponseEntity<DetailResponse> getDetailDashboard() throws Exception {


        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
