package com.wet.featsoflove;

import javax.validation.Valid;

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
	private final static String UNSUCCESSFUL_SUBSCRIBE_MESSAGE = "Please enter a valid email address.";
	private final static String UNSUCCESSFUL_MESSAGE_CLASS = "unsuccessful-message";
	
	@Autowired
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) 
	{
		binder.setValidator(validator);
	}
	
	@Autowired
	SubscriberService subscriberService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model)
	{	
		model.addAttribute("subscriber", new Subscriber());
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String subscribe(@Valid @ModelAttribute("subscriber") Subscriber subscriber, BindingResult result)
	{
		if (!result.hasErrors()) 
		{
			subscriberService.subscribeAndConfirm(subscriber);
        }
		
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