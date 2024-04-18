package ddt;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleExample {
    public static void main(String[] args) {
        String jsonString = "{\"name\": \"John\", \"age\": 30}";
        
        JSONParser parser = new JSONParser();
        
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
            
            String name = (String) jsonObject.get("name");
            long age = (Long) jsonObject.get("age");
            
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}