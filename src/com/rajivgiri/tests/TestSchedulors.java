package com.rajivgiri.tests;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.rajivgiri.runnables.CleaningProcessor;

public class TestSchedulors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		//service.schedule(new CleaningProcessor(), 5, TimeUnit.SECONDS);
		//service.scheduleAtFixedRate(new CleaningProcessor(), 5,4, TimeUnit.SECONDS);
		
		service.scheduleWithFixedDelay(new CleaningProcessor(), 5,4, TimeUnit.SECONDS);
		
	}

}
