package com.rajivgiri.runnables;

import java.io.File;

public class CleaningProcessor implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File folder = new File("E:\\SQL Server 2019\\MSSQL15.MSSQLSERVER\\MSSQL\\Log");
		File[] files = folder.listFiles();
		for(File file:files) {
			if(System.currentTimeMillis()-file.lastModified()>5*60*1000);
			System.out.println("This file will be Deleted: " + file.getName());
			//file.delete();
		}
	}

}
