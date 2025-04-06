package com.devRenan01.corse.resouces.excepitions;

import java.io.Serializable;
import java.time.Instant;

public class StandardardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private Integer status;
	private String Error;
	private String message;
	private String path;
	
	public StandardardError() {
		
	}

	public StandardardError(Instant timestamp, Integer status, String error, String message, String path) {
		this.timestamp = timestamp;
		this.status = status;
		Error = error;
		this.message = message;
		this.path = path;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
