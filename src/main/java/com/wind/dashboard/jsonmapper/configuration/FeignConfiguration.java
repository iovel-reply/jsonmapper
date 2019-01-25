package com.wind.dashboard.jsonmapper.configuration;

import com.wind.dashboard.jsonmapper.exception.ClientsErrorDecoder;
import feign.Logger;
import feign.Request;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 10000;

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options() {
        return new Request.Options(CONNECTION_TIMEOUT, READ_TIMEOUT);
    }

    @Bean
    public ErrorDecoder ClientsErrorDecoder() {
        return new ClientsErrorDecoder();
    }

}
