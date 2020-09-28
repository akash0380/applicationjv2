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
@RequestMapping("/welcome")
public class WelcomeController {

	@ResponseBody
	@RequestMapping(value = "/checkactiveprofile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String checkActiveProfile() throws IOException {
		Resource resource = null;
		Properties props = PropertiesLoaderUtils
				.loadProperties(new ClassPathResource(ApplicationConstants.profile0.toString()));
		resource = new ClassPathResource(ApplicationConstants.profile1);
		props = PropertiesLoaderUtils.loadProperties(resource);
		return MessageFormat.format(ApplicationConstants.WEl002, props.getProperty(ApplicationConstants.prop1Var));
	}

}
