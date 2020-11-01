package com.ApplicationJ.utility;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ApplicationJ.config.Response;

public interface SupportUtility {

	static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	Response responseBuilder(String message, Object data, String route);

	String getValue(String popName);

}
