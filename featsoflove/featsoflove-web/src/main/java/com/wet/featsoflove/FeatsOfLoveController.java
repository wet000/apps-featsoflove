package com.wet.featsoflove;

import java.security.Principal;
import java.util.Iterator;

import javax.persistence.PersistenceException;
import javax.validation.Valid;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.wet.api.notification.model.Subscriber;
import com.wet.api.notification.service.SubscriberService;

@Component
@Controller
@RequestMapping(value={"","/","/home"})
public class FeatsOfLoveController
{
	private final static String SUCCESSFUL_SUBSCRIBE_MESSAGE = "Thank You! We will keep you informed.";
	private final static String UNSUCCESSFUL_SUBSCRIBE_MESSAGE = "Please enter a valid email address.";
	private final static String SUCCESSFUL_MESSAGE_CLASS = "successful-message";
	private final static String UNSUCCESSFUL_MESSAGE_CLASS = "unsuccessful-message";
	
//	@Autowired
//	private Validator validator;
//
//	@InitBinder
//	protected void initBinder(WebDataBinder binder) 
//	{
//		binder.setValidator(validator);
//	}
	
	@Autowired
	SubscriberService subscriberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home()
	{	
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String subscribe(@Valid @ModelAttribute Subscriber subscriber, BindingResult result,
							@RequestParam("email") String email, @RequestParam("formId") short formId, Model model)
	{
		//Subscriber subscriber = new Subscriber();
		subscriber.setFormId(formId);
		subscriber.setEmail(email);
		
		subscriberService.subscribeAndConfirm(subscriber);
		
//		 errors = result.getAllErrors();
//	    for (FieldError error : errors ) {
//	        System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
//	    }
//		
//		
//		//model.addAttribute("message", result.);
//		model.addAttribute("messageClass", SUCCESSFUL_MESSAGE_CLASS);
		
		// TODO: Use in exception handling and when verification fails
		//model.addAttribute("message", UNSUCCESSFUL_SUBSCRIBE_MESSAGE);
		//model.addAttribute("messageClass", UNSUCCESSFUL_MESSAGE_CLASS);
		
		return "home";
	}
	
	@ExceptionHandler(Exception.class) 
	public ModelAndView handleIOException(Exception e) 
	{
		ModelAndView mav = new ModelAndView("home");
				mav.addObject("message", UNSUCCESSFUL_SUBSCRIBE_MESSAGE);
				mav.addObject("messageClass", UNSUCCESSFUL_MESSAGE_CLASS);
				
				
//				model.addAllObjects(request.getParameterMap());  
//				for(Iterator<String> names = request.getHeaderNames(); names.hasNext(); ) 
//				{
//					String name =  names.next();
//					String[] value = request.getHeaderValues(name);
//					model.addObject(name, value);
//				}     
		
		return mav;
	} 
	
	@ExceptionHandler(CannotCreateTransactionException.class) 
	public ModelAndView handleIOException(CannotCreateTransactionException e) 
	{
		ModelAndView mav = new ModelAndView("home");
				mav.addObject("message", e.getMessage());
				mav.addObject("messageClass", UNSUCCESSFUL_MESSAGE_CLASS);
				
				
//				model.addAllObjects(request.getParameterMap());  
//				for(Iterator<String> names = request.getHeaderNames(); names.hasNext(); ) 
//				{
//					String name =  names.next();
//					String[] value = request.getHeaderValues(name);
//					model.addObject(name, value);
//				}     
		
		return mav;
	} 	
}