package com.wet.featsoflove.landingpages.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wet.api.notification.model.Subscriber;
import com.wet.api.notification.service.SubscriberService;
import com.wet.featsoflove.landingpages.service.LandingPagesService;

@Component
public class LandingPagesServiceImpl implements LandingPagesService
{
	@Autowired
	private SubscriberService subscriberService;
	
	@Override
	public void subscribe(Subscriber subscriber)
	{
		subscriberService.subscribeAndConfirm(subscriber);
	}
}