package com.wet.featsoflove.landingpages.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.validation.BindingResult;

import com.wet.api.notification.model.Subscriber;
import com.wet.featsoflove.landingpages.service.LandingPagesService;

@Component
@Controller
@RequestMapping(value={"","/","/home"})
public class LandingPagesController
{
	@Autowired
	private LandingPagesService landingPagesService;
	
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
			landingPagesService.subscribe(subscriber);
        }
		
		return "home";
	}
}