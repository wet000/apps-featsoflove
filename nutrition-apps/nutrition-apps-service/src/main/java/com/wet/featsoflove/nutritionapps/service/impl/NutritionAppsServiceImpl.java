package com.wet.featsoflove.nutritionapps.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wet.api.nutrition.service.NutritionService;
import com.wet.featsoflove.nutritionapps.service.NutritionAppsService;

@Component
public class NutritionAppsServiceImpl implements NutritionAppsService 
{
	@Autowired
	private NutritionService nutritionService;
	
	@Override
	public void crawl() 
	{
	    nutritionService.crawlNutritionDatabase();
	}
}