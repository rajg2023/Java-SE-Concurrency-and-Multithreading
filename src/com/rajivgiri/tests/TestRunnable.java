package com.rajivgiri.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TestRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable runnable =()->{
			try(BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\rgiri\\OneDrive\\Desktop\\Bootcamp\\Power punch 60 second elevator pitch and penut butter jelly sandwich.txt"))){
				String line = null;
				
				while((line=read.readLine())!=null){
					System.out.println(Thread.currentThread().getName()+"Reading your resume" + line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		};
		//***********Runnable Instances*****************************************************************//
		System.out.println("//***********Runnable Instances*****************************************************************//");
		 Thread thread = new Thread(runnable);
	     thread.start();
		
	     System.out.println("//***********Executor Services*****************************************************************//");
	   //***********Executor Services*****************************************************************//
		Executor executor = Executors.newSingleThreadExecutor();
		executor.execute(runnable);
		
	}

}
