package com.wet.featsoflove.nutritionapps.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wet.featsoflove.nutritionapps.service.NutritionAppsService;

@Component
@Controller
@RequestMapping(value={"/nutrition"})
public class NutritionAppsController
{
	@Autowired
	private NutritionAppsService nutritionAppsService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String nutrition(Model model)
	{
		nutritionAppsService.crawl();
		return "nutrition";
	}
}