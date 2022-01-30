package com.rajivgiri.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.rajivgiri.dao.UserDAO;
import com.rajivgiri.runnables.UserRunnable;

public class TestExecutors {

	public static void main(String[] args) {
		
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		List<String> users = getUsersFromFile("/JavaSEConcurrency/NewUsers.txt");
		UserDAO dao = new UserDAO();
		for(String user:users) {
			Future<Integer>future= service.submit(new UserRunnable(user, dao));
			try {
				System.out.println("Result of the operation is: "+future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		service.shutdown();
		System.out.println("Main execution Over!!");
		//System.out.println(new java.io.File("src/NewUsers.txt").getAbsolutePath());
		

	}
	
	public static List<String> getUsersFromFile(String fileName) {
		List<String>users=new ArrayList<>();
		try(BufferedReader read = new BufferedReader(new FileReader(new File(fileName)))){
			String line = null;
			
			while((line=read.readLine())!=null){
				users.add(line);
				//System.out.println(Thread.currentThread().getName()+"Reading your resume" + line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Where is your file?");
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return users;
	}

}
