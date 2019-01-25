package com.wind.dashboard.jsonmapper.client;

import com.wind.dashboard.jsonmapper.exception.JsonMapperException;
import com.wind.dashboard.jsonmapper.model.dto.input.UserData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "UserDataFeignClient", url = "${user.data.url}")
public interface UserDataClient {

    @RequestMapping(method = RequestMethod.GET)
    UserData getUserData(@RequestParam(value = "msisdn") String msisdn) throws JsonMapperException;
}
