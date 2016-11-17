package com.wet.featsoflove.web.controller;

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
import com.wet.featsoflove.service.FeatsOfLoveService;

@RunWith(MockitoJUnitRunner.class)
public class FeatsOfLoveControllerTest 
{
	private FeatsOfLoveController featsOfLoveController;

	@Mock
	private FeatsOfLoveService mockFeatsOfLoveService;
	
	@Mock
	private BindingResult mockBindingResult;
	
	@Before
	public void setup()
	{
		featsOfLoveController = new FeatsOfLoveController();
		Whitebox.setInternalState(featsOfLoveController, "featsOfLoveService", mockFeatsOfLoveService);
	}
	
	@Test
	public void testSubscribe()
	{
		Subscriber subscriber = new Subscriber();
		doNothing().when(mockFeatsOfLoveService).subscribe(subscriber);
		
		String page = featsOfLoveController.subscribe(subscriber, mockBindingResult);
		
		assertThat(page, is(equalTo("home")));
		verify(mockFeatsOfLoveService).subscribe(subscriber);
	}
	
	@Test
	public void testSubscribeError()
	{
		Subscriber subscriber = new Subscriber();
		when(mockBindingResult.hasErrors()).thenReturn(true);
		
		String page = featsOfLoveController.subscribe(subscriber, mockBindingResult);
		
		assertThat(page, is(equalTo("home")));
		verify(mockFeatsOfLoveService, never()).subscribe(subscriber);
	}
}