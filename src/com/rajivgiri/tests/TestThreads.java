package com.rajivgiri.tests;

import com.rajivgiri.runnables.ApplicationThread;

public class TestThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationThread thread1 = new ApplicationThread();
		ApplicationThread thread2 = new ApplicationThread();
		ApplicationThread thread3 = new ApplicationThread();
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		thread2.setPriority(1);
		thread3.setPriority(5);
		thread1.getState();
	}

}
