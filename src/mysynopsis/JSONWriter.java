/* 
 * The MIT License
 *
 * Copyright 2016 Tonmoay Deb <tonmoay.deb@northsouth.edu>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mysynopsis;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Tonmoay Deb
 * 
 * This Class will export all variable data to a JSON ( data.json ) file
 * 
 */
public abstract class JSONWriter extends Variables {
    
    public static void  writeData() throws IOException {
        
        JSONObject bio = new JSONObject();
        bio.put("Name",name);
        bio.put("Initial",initial);
        bio.put("Bio", biog);
        bio.put("Designation", designation);
        bio.put("Department",dept);
        bio.put("University",university);
        bio.put("University_Address",universityAddress);
        bio.put("Office", office);
        bio.put("Ohours", officehours);
        bio.put("Phone", phone);
        bio.put("Email", email);
        bio.put("Resume_Link",resumelink);
        bio.put("Educational",education);
        bio.put("Professional",professional);
        
        bio.put("Awards",awards);
        
        bio.put("Image_Ext",imgExtension);
        bio.put("Image_String",imgString);
        
        /*JSONArray education = new JSONArray();
        for(int i=0;i<8;i++) {
        education.add(educ[i]);
        }
        bio.put("Education",education);*/
        
        JSONArray ftpinfo = new JSONArray();
        
        ftpinfo.add(server);
        ftpinfo.add(user);
        ftpinfo.add(dir);
        
        bio.put("Server_Information",ftpinfo);
        
        try (FileWriter file = new FileWriter("data.json")) {
            
	file.write(bio.toJSONString());
	}
        catch(IOException e) {
            
            JOptionPane.showMessageDialog(null,"Can't Create Data.json File. Please Check Your Directory Permission");
        }
    }
    
    
}
