package com.wind.dashboard.jsonmapper.exception;

import com.google.gson.Gson;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Slf4j
public class ClientsErrorDecoder implements ErrorDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsErrorDecoder.class);

    @Override
    public JsonMapperException decode(final String method, final Response response) {
        ApiResponse apiResponse = null;
        final Gson gson = new Gson();
        try {
            if (null != response.body()) {
                apiResponse = gson.fromJson(response.body().asReader(), ApiResponse.class);
            } else {
                final String reason = response.reason() != null ? response.reason() : "Empty body response in decoder";
                apiResponse = new ApiResponse(String.valueOf(response.status()), ResponseType.ERROR.value(), reason);
            }
        } catch (final IOException ioe) {
            ClientsErrorDecoder.LOGGER.warn("Exception in error decoder: {}", ioe.getMessage());
        }
        return new JsonMapperException(new FeignErrorCode(apiResponse.getMessage(), apiResponse.getCode()));
    }
}

