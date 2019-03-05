package com.annote_practice.spring_app_annotations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class App5FortuneService implements FortuneService {
	// Read from file 
	// Load into array
	// return random element from array
	private ArrayList<String> messages;
	private boolean manualMessageAdded;
	private String manualMessage;
	
	public App5FortuneService(){
		manualMessage = "";
		manualMessageAdded = false;
		messages = new ArrayList<String>();
	}
	
	@PostConstruct
	public void getMessages() {
		File myFile = new File("./src/com/annote_practice/spring_app_annotations/Input.txt");
		Scanner scan;
		try {
			scan = new Scanner(myFile);
			while (scan.hasNextLine()) {
				messages.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	public void clearMemory() {
		messages.clear();
	}
	
	@Override
	public String getFortune() {
		Random myRand = new Random();
		int index = myRand.nextInt(messages.size());
		return manualMessageAdded ? manualMessage: messages.get(index);
	}

	@Override
	public void setFortune(String arg) {
		this.manualMessageAdded = true;
		this.manualMessage = arg;
	}

}
