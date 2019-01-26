package com.wind.dashboard.jsonmapper.exception;

import com.wind.dashboard.jsonmapper.exception.enums.ErrorCode;
import lombok.Data;

@Data
public class BadRequestException extends JsonMapperException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3899019773620179264L;

	public BadRequestException(ErrorCode errorCode) {
		super(errorCode);
	}

	public BadRequestException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}

	@Deprecated
	public BadRequestException() {
	}

	@Deprecated
	public BadRequestException(String message) {
		super(message);
	}
}
