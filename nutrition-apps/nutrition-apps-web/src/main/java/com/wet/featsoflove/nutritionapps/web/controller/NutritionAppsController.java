package com.wet.featsoflove.nutritionapps.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@Controller
@RequestMapping(value={"/nutrition"})
public class NutritionAppsController
{	
	@RequestMapping(method=RequestMethod.GET)
	public String nutrition(Model model)
	{	
		return "nutrition";
	}
}