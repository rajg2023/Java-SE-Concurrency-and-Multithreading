package com.rajivgiri.custom;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

	private static int counter = 0;
	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		
		Thread thread = new Thread(r);
		thread.setName("Custom Thread -" +(++counter));
		return thread;
	}
	
	

}
