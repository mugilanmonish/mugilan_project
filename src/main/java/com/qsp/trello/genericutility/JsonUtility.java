package com.qsp.trello.genericutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String readTheDataFromJsonFile(String key) throws IOException, ParseException {
		JSONParser parser = new JSONParser();	
		FileReader reader = new FileReader("./src/test/resource/testdata.json"); 
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		String value = (String) jsonObject.get(key); 
		return value;
	}
}