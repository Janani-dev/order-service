package com.oms.order.exception;

import org.springframework.http.HttpStatus;

public class OrderServiceException extends RuntimeException
{
	private HttpStatus status = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

	public OrderServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
