package com.ApplicationJ.utility;

import org.springframework.stereotype.Component;

import com.ApplicationJ.config.Response;

@Component
public class SupportUtilityImpl implements SupportUtility {

	@Override
	public Response responseBuilder(int status, String message, Object data, String route) {
		Response response = new Response();
		response.setStatus(status);
		response.setPath("/"+route);
		response.setMessage(message);
		response.putData(route, data);
		return response;
	}
	
}
