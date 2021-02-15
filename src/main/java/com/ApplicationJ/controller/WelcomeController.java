package com.ApplicationJ.controller;

import java.io.IOException;
import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.ApplicationJ.config.ApplicationConstants;
import com.ApplicationJ.utility.SupportUtility;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	@Autowired
	SupportUtility supportUtility;

	@ResponseBody
	@RequestMapping(value = "/checkactiveprofile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	String checkActiveProfile(@RequestHeader(value = "authKey") String authKey) throws IOException {	
	return MessageFormat.format(ApplicationConstants.WEl002,
			supportUtility.getValue(ApplicationConstants.propDev__application_name));
	}

}
