package com.ApplicationJ.utility;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.config.Response;

@Component
public class SupportUtilityImpl implements SupportUtility {

	@Override
	public Response responseBuilder(String message, Object data, String route) {
		Response response = new Response();
		response.setPath("/"+route);
		response.setMessage(message);
		response.putData(route, data);
		return response;
	}
	
	@Override
	public String getValue(String popName) {
		String out=null;
		try {			
		Properties props = PropertiesLoaderUtils.loadProperties(new ClassPathResource(ApplicationConstants.profile));
		//if block for dev profile
		if (props.getProperty(ApplicationConstants.activeProfile).equals(ApplicationConstants.profile1NameDev)) {
			Resource resource = new ClassPathResource(ApplicationConstants.profileDev);
			props = PropertiesLoaderUtils.loadProperties(resource);
			out=props.getProperty(popName);
		}
		}catch(Exception e) {
			logger.debug("unable to get read properties file");
		}
		return out;
	}
	
}
