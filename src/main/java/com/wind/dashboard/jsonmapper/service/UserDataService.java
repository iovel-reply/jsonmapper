package com.wind.dashboard.jsonmapper.service;

import com.wind.dashboard.jsonmapper.client.UserDataClient;
import com.wind.dashboard.jsonmapper.exception.JsonMapperException;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDataService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDataService.class);
    private final UserDataClient client;

    public UserData retrieveUserData() throws JsonMapperException {
        UserData userData = client.getUserData();
        LOGGER.debug(userData.toString());

        return userData;
    }
}
