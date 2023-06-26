package com.inditex.productos.ecommerce.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EcommerceError {

	@JsonProperty("message")
	private String message;
	@JsonProperty("status_code")
	private int statusCode;
	@JsonProperty("uri")
	private String uriRequested;

	public EcommerceError(int statusCode, String message, String uriRequested) {
		this.message = message;
		this.statusCode = statusCode;
		this.uriRequested = uriRequested;
	}

	public EcommerceError(int statusCode, String message) {
		this.message = message;
		this.statusCode = statusCode;

	}

	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getUriRequested() {
		return uriRequested;
	}

}
