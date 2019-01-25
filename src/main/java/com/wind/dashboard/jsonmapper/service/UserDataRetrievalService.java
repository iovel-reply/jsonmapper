package com.wind.dashboard.jsonmapper.service;

import com.wind.dashboard.jsonmapper.client.UserDataClient;
import com.wind.dashboard.jsonmapper.exception.JsonMapperException;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserDataRetrievalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDataRetrievalService.class);

    @Autowired
    private UserDataClient client;

    public UserData retrieveUserData() throws JsonMapperException {
        UserData userData = null;
        userData = client.getUserData(null);
        LOGGER.info(userData.toString());

        return userData;
    }
}
