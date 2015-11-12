package com.wet.featsoflove.web.controller.advice;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class FeatsOfLoveControllerAdvice 
{
	private static final String ATTRIBUTE_ERROR_MESSAGE = "errorMessage";
	private static final String INTERNAL_SERVER_ERROR_PAGE = "error".concat(File.separator).concat("500");
	
	@Autowired
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) 
	{
		binder.setValidator(validator);
	}
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView handleIOException(CannotCreateTransactionException exception, WebRequest request) 
	{
		ModelAndView mav = new ModelAndView(INTERNAL_SERVER_ERROR_PAGE);
		mav.addObject(ATTRIBUTE_ERROR_MESSAGE, exception.getRootCause().getMessage());
		
		return mav;
	} 	
}