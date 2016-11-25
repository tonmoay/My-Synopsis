/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Personal
 */
public class JSONInit  {
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void initSystem() throws FileNotFoundException, IOException {
        try {
            FileInputStream fstream;
            fstream = new FileInputStream("data.json");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            setDefault();

        }
    }
    
    public static void setDefault() throws IOException {
        JSONObject bio = new JSONObject();
        bio.put("Name","Adnan Firoze");
        bio.put("Bio", "");
        bio.put("Designation", "Lecturer");
        bio.put("Department", "Electrical & Computer Engineering");
        bio.put("University", "North South University, Bangladesh");
        bio.put("Office", "SAC931");
        bio.put("Ohours", "ST 12-1PM, MW 1-2.30PM");
        bio.put("Phone", "016666666");
        bio.put("Email", "adnan.firoze@northsouth.edu");
        bio.put("Resume_Link","http://linkedin.com");

        JSONArray education = new JSONArray();
        education.add("College: Notre Dame College,Dhaka.");
        education.add("Bsc. in Computer Science & Engineering: North South University");
        education.add("Msc. in Computer Science & Engineering: Columbia University, NY");
        bio.put("Education", education);
        
        
        JSONArray professional = new JSONArray();
        professional.add("Profession 1: ");
        professional.add("Profession 2: ");
        bio.put("Professional Experience:", professional);
        
        JSONArray awards = new JSONArray();
        awards.add("Award 1: ");
        awards.add("Award 2: ");
        bio.put("Honors & Awards:", awards);
        
        try (FileWriter file = new FileWriter("data.json")) {
            
	file.write(bio.toJSONString());
	}
        
    }
    
    
}
