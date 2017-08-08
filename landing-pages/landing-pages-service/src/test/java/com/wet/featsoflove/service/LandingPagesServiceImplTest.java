package com.wet.featsoflove.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import com.wet.api.notification.model.Subscriber;
import com.wet.api.notification.service.SubscriberService;
import com.wet.featsoflove.landingpages.service.LandingPagesService;
import com.wet.featsoflove.landingpages.service.impl.LandingPagesServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LandingPagesServiceImplTest 
{
	private LandingPagesService landingPagesService;

	@Mock
	private SubscriberService mockSubscriberService;
	
	@Before
	public void setup()
	{
		landingPagesService = new LandingPagesServiceImpl();
		Whitebox.setInternalState(landingPagesService, "subscriberService", mockSubscriberService);
	}
	
	@Test
	public void testSubscribe()
	{
		Subscriber subscriber = new Subscriber();
		
		doNothing().when(mockSubscriberService).subscribeAndConfirm(subscriber);
		landingPagesService.subscribe(subscriber);
		
		verify(mockSubscriberService).subscribeAndConfirm(subscriber);
	}
}