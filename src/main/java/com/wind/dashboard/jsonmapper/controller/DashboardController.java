package com.wind.dashboard.jsonmapper.controller;


import com.wind.dashboard.jsonmapper.exception.BadRequestException;
import com.wind.dashboard.jsonmapper.exception.JsonMapperException;
import com.wind.dashboard.jsonmapper.exception.enums.BadRequestErrorCode;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import com.wind.dashboard.jsonmapper.model.dto.aggregated.AggregatedDTO;
import com.wind.dashboard.jsonmapper.model.dto.detail.DetailDTO;
import com.wind.dashboard.jsonmapper.service.AggregatedService;
import com.wind.dashboard.jsonmapper.service.DetailService;
import com.wind.dashboard.jsonmapper.service.UserDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/dashboard")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DashboardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

    private final AggregatedService aggregatedService;
    private final DetailService detailService;
    private final UserDataService userDataService;


    @RequestMapping(path = "/aggregated", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<AggregatedDTO> getAggregated() throws JsonMapperException {
        LOGGER.debug("New Aggregated Dashboard Request");
        Optional<UserData> data = Optional.ofNullable(userDataService.retrieveUserData());
        AggregatedDTO response = aggregatedService.getDashboard(data.orElseThrow(() -> new BadRequestException(BadRequestErrorCode.MISSING_USER_DATA)));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(path = "/detail/{tag}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<DetailDTO> getDetail(@PathVariable(value = "tag") String tag) throws JsonMapperException {
        LOGGER.debug("New Detail Dashboard Request");
        Optional<UserData> data = Optional.ofNullable(userDataService.retrieveUserData());
        DetailDTO response = detailService.getDashboard(data.orElseThrow(() -> new BadRequestException(BadRequestErrorCode.MISSING_USER_DATA)), tag);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
