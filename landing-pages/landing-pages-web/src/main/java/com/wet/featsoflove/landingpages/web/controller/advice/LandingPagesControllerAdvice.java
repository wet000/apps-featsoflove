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

import com.wet.api.notification.model.Subscriber;
import com.wet.api.notification.service.exception.DuplicateSubscriberException;

@ControllerAdvice
public class LandingPagesControllerAdvice 
{
	private static final String ATTRIBUTE_SUBSCRIBER = "subscriber";
	private static final String ATTRIBUTE_MESSAGE = "message";
	private static final String INTERNAL_SERVER_ERROR_PAGE = "error".concat(File.separator).concat("500");
	
	@Autowired
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) 
	{
		binder.setValidator(validator);
	}
	
	@ExceptionHandler(DuplicateSubscriberException.class)
	public ModelAndView handleDuplicateSubscriberException(DuplicateSubscriberException exception, WebRequest request)
	{
		ModelAndView mav = new ModelAndView("home");

		// Set the email and formId if you want these to be set on the form when returning
		Subscriber subscriber = new Subscriber();
		subscriber.setEmail(request.getParameterValues("email")[0]);
		subscriber.setFormId(Short.valueOf(request.getParameterValues("formId")[0]));
		
		mav.addObject(ATTRIBUTE_SUBSCRIBER, subscriber);
		mav.addObject(ATTRIBUTE_MESSAGE, exception.getMessage());
		
		return mav;
	}
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView handleIOException(CannotCreateTransactionException exception) 
	{
		ModelAndView mav = new ModelAndView(INTERNAL_SERVER_ERROR_PAGE);
		mav.addObject(ATTRIBUTE_MESSAGE, exception.getRootCause().getMessage());
		
		return mav;
	} 	
}