/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author Personal
 */
public class JSONWriter extends Frames {
    
    public void writeData() throws IOException {
        JSONObject bio = new JSONObject();
        bio.put("Name",name);
        bio.put("Bio", biog);
        bio.put("Designation", designation);
        bio.put("Department",dept);
        bio.put("University",university);
        bio.put("Office", office);
        bio.put("Ohours", officehours);
        bio.put("Phone", phone);
        bio.put("Email", email);
        bio.put("Resume_Link",resumelink);
        
        try (FileWriter file = new FileWriter("data.json")) {
            
	file.write(bio.toJSONString());
	}
    }
    
    
}
