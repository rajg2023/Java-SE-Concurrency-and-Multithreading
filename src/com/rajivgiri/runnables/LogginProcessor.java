package com.rajivgiri.runnables;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogginProcessor implements Callable<Boolean>{

	@Override
	public Boolean call() throws Exception {
		// TODO Auto-generated method stub
		Logger.getLogger(LogginProcessor.class.getName()).log(Level.INFO,"Logging something");
		return true;
	}

}
