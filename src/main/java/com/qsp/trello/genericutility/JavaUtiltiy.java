package com.qsp.trello.genericutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.LocalDateTime;

public class JavaUtiltiy {
	public String localDateAndTime() {
		String dateAndTime = LocalDateTime.now().toString().replace(':', '-');
		return dateAndTime;
	}
	
	public void robotClass() throws AWTException {
		Robot robot = new Robot();
		
	}
}
