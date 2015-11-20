package com.wet.featsoflove.web.controller;

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
import com.wet.featsoflove.service.FeatsOfLoveService;

@Component
@Controller
@RequestMapping(value={"","/","/home"})
public class FeatsOfLoveController
{
	@Autowired
	FeatsOfLoveService featsOfLoveService;
	
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
			featsOfLoveService.subscribe(subscriber);
        }
		
		return "home";
	}
}