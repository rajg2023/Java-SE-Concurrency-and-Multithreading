package com.rajivgiri.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ApplicationThread extends Thread {
	
	@Override
	
	public void run() {
		try(BufferedReader read = new BufferedReader(new FileReader(new File("C:\\Users\\rgiri\\OneDrive\\Desktop\\Bootcamp\\Power punch 60 second elevator pitch and penut butter jelly sandwich.txt")))){
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
		
	}

}
