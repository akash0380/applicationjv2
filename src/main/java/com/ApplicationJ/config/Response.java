package com.ApplicationJ.config;

import java.util.HashMap;
import java.util.Map;

public class Response {

	private String message;

	private String path;

	private Map<String, Object> data = new HashMap<>();

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

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public void putData(String key, Object Value) {

		data.put(key, Value);
	}
	
}
