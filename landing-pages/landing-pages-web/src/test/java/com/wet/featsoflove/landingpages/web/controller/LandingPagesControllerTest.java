package com.wet.featsoflove.landingpages.web.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;

import com.wet.api.notification.model.Subscriber;
import com.wet.featsoflove.landingpages.service.LandingPagesService;

@RunWith(MockitoJUnitRunner.class)
public class LandingPagesControllerTest 
{
	private LandingPagesController landingPagesController;

	@Mock
	private LandingPagesService mockLandingPagesService;
	
	@Mock
	private BindingResult mockBindingResult;
	
	@Before
	public void setup()
	{
		landingPagesController = new LandingPagesController();
		Whitebox.setInternalState(landingPagesController, "landingPagesService", mockLandingPagesService);
	}
	
	@Test
	public void testSubscribe()
	{
		Subscriber subscriber = new Subscriber();
		doNothing().when(mockLandingPagesService).subscribe(subscriber);
		
		String page = landingPagesController.subscribe(subscriber, mockBindingResult);
		
		assertThat(page, is(equalTo("home")));
		verify(mockLandingPagesService).subscribe(subscriber);
	}
	
	@Test
	public void testSubscribeError()
	{
		Subscriber subscriber = new Subscriber();
		when(mockBindingResult.hasErrors()).thenReturn(true);
		
		String page = landingPagesController.subscribe(subscriber, mockBindingResult);
		
		assertThat(page, is(equalTo("home")));
		verify(mockLandingPagesService, never()).subscribe(subscriber);
	}
}