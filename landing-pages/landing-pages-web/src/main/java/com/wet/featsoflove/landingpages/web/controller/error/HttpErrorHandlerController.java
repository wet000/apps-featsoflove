package com.wet.featsoflove.landingpages.web.controller.error;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorHandlerController 
{
	private final static String ERROR_DIR = "error";
	private final static String ERROR_BAD_REQUEST = "400";
	private final static String ERROR_UNAUTHORIZED = "401";
	private final static String ERROR_FORBIDDEN = "403";
	private final static String ERROR_NOT_FOUND = "404";
	private final static String ERROR_INTERNAL_SERVER_ERROR = "500";
	
	@RequestMapping(value="/" + ERROR_BAD_REQUEST)
    public String errorBadRequest()
	{
		return ERROR_DIR.concat(File.separator).concat(ERROR_BAD_REQUEST);
    }
	
	@RequestMapping(value="/" + ERROR_UNAUTHORIZED)
    public String errorUnauthorized()
	{
		return ERROR_DIR.concat(File.separator).concat(ERROR_UNAUTHORIZED);
    }
	
	@RequestMapping(value="/" + ERROR_FORBIDDEN)
    public String errorForbidden()
	{
		return ERROR_DIR.concat(File.separator).concat(ERROR_FORBIDDEN);
    }
	
	@RequestMapping(value="/" + ERROR_NOT_FOUND)
    public String errorNotFound()
	{
		return ERROR_DIR.concat(File.separator).concat(ERROR_NOT_FOUND);
    }
	
	@RequestMapping(value="/" + ERROR_INTERNAL_SERVER_ERROR)
    public String errorInternalServerError()
	{
		return ERROR_DIR.concat(File.separator).concat(ERROR_INTERNAL_SERVER_ERROR);
    }
}