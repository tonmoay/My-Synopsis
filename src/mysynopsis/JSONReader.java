/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Personal
 */
public class JSONReader extends JSONWriter {
    
    public void readData() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("data.json"));
        JSONObject read;
        read = (JSONObject) obj;
        
        name = (String)read.get("Name");
        biog = (String)read.get("Bio");
        designation = (String)read.get("Designation");
        dept = (String)read.get("Department");
        university = (String)read.get("University");
        office = (String)read.get("Office");
        officehours = (String)read.get("Ohours");
        phone = (String)read.get("Phone");
        email = (String)read.get("Email");
        resumelink = (String)read.get("Resume_Link");
        
    }
    
}
