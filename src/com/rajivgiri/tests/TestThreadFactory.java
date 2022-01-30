package com.rajivgiri.tests;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.rajivgiri.custom.CustomThreadFactory;
import com.rajivgiri.runnables.LogginProcessor;

public class TestThreadFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExecutorService service = Executors.newFixedThreadPool(3,new CustomThreadFactory());
		for(int i=0; i<6; i++) {
			service.submit(new LogginProcessor());
			
		}

	}

}
