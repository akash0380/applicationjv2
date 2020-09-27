package com.ApplicationJ.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ApplicationJ.config.ApplicationConstants;

@Controller
public class HomeController {
    
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	String welcome() {
		//don't change this please, below code is for monolithic application  
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String showProfile() {
		try {
			Resource resource = null;
			Properties props = PropertiesLoaderUtils
					.loadProperties(new ClassPathResource("/application.properties"));
			if (props.getProperty("spring.profiles.active").equals("dev")) {
				resource = new ClassPathResource("/application-dev.properties");
				props = PropertiesLoaderUtils.loadProperties(resource);
				System.out.println();
				return MessageFormat.format(ApplicationConstants.WEl002, props.getProperty("application.name"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
