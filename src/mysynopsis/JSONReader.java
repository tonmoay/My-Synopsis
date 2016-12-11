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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Tonmoay Deb
 *  
 */
public abstract class JSONReader extends Variables {
    
    //This Class reads data from data.json file which has been already generated.
    
    public static void readData() throws FileNotFoundException, IOException, ParseException {
        
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("data.json"));
            JSONObject read;
            read = (JSONObject) obj;
            
            name = (String) read.get("Name");
            initial = (String) read.get("Initial");
            biog = (String) read.get("Bio");
            designation = (String) read.get("Designation");
            dept = (String) read.get("Department");
            university = (String) read.get("University");
            universityAddress = (String) read.get("University_Address");
            office = (String) read.get("Office");
            officehours = (String) read.get("Ohours");
            phone = (String) read.get("Phone");
            email = (String) read.get("Email");
            resumelink = (String) read.get("Resume_Link");
            education = (String) read.get("Educational");
            professional = (String) read.get("Professional");
            awards = (String) read.get("Awards");
            
            imgExtension = (String) read.get("Image_Ext");
            imgString = (String) read.get("Image_String");

            /*JSONArray education = (JSONArray) read.get("Education");
        
        for(int i=0;i<8;i++) {
        
        educ[i] = (String) education.get(i);
        
        }*/
            JSONArray ftpinfo = (JSONArray) read.get("Server_Information");
            
            server = (String) ftpinfo.get(0);
            user = (String) ftpinfo.get(1);
            dir = (String) ftpinfo.get(2);
        } catch (IOException | ParseException e) {
            
            JOptionPane.showMessageDialog(null,"Something went wrong. Please re-run the software.");
        }
    }
    
}
