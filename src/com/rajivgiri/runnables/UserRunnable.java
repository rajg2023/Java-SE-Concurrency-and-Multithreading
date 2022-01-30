package com.rajivgiri.runnables;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import com.rajivgiri.beans.User;
import com.rajivgiri.dao.UserDAO;

public class UserRunnable implements Callable<Integer>{

	private String userRecord;
	private UserDAO dao;
	
	public UserRunnable(String userRecord, UserDAO dao) {
		// TODO Auto-generated constructor stub
	
		this.userRecord=userRecord;
		this.dao= dao;

	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int rows = 0;
		System.out.println(Thread.currentThread().getName()+"Processing record for: " +userRecord);
		StringTokenizer tokenizer = new StringTokenizer(userRecord, ",");
		User user = null;
		while(tokenizer.hasMoreTokens()){
			user = new User();			
			user.setEmail(tokenizer.nextToken());
			user.setName(tokenizer.nextToken());
			user.setId(Integer.valueOf(tokenizer.nextToken()));
			rows = dao.saveUser(user);
			
			
		}
		return rows;
			

	
	}


}
