package com.rajivgiri.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.rajivgiri.runnables.LogginProcessor;

public class TestingOtherAPI {
	
	public static void main(String[] args){
	
		ExecutorService service = Executors.newFixedThreadPool(2);
		List<Callable<Boolean>> callables = new ArrayList<>();
		
		try {
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		callables.add(new LogginProcessor());
		
		
		List<Future<Boolean>>futures = service.invokeAll(callables);
		
		for(Future<Boolean>future:futures) {
			
				System.out.println("Operation Invoke ALL Results : " + future.get());
			}
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		try {
			System.out.println("Operation Invoke ANY Results : " + service.invokeAny(callables));
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
		
		try {
			System.out.println("Service shutdown Yet?: " + service.awaitTermination(30, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			service.shutdownNow();
			e.printStackTrace();
		}

        }
	}
