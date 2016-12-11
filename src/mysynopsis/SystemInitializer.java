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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Tonmoay Deb
 * 
 */

public abstract class SystemInitializer {   
    
    //This Class initializes system & creates files with default value ( if none )
    /**
     * @throws IOException
     */
    public static void initSystem() throws IOException {
        try {
            FileInputStream fstream;
            fstream = new FileInputStream("data.json");
            fstream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            setDefault();

        }
        try {
            FileInputStream fstream;
            fstream = new FileInputStream("template.html");
            fstream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            setDefaultHTML();

        }
    }
    
    private static void setDefault() throws IOException {
        JSONObject bio = new JSONObject();
        bio.put("Name","");
        bio.put("Initial","");
        bio.put("Bio", "<p><font face=\"Arial\" size=\"4\"><b>Biography goes here</b></font></p><p><br></p><p></p><p><font face=\"Segoe UI\" size=\"4\"><br></font></p>");
        bio.put("Designation", "");
        bio.put("Department", "");
        bio.put("University", "");
        bio.put("University_Address","");
        bio.put("Office", "");
        bio.put("Ohours", "");
        bio.put("Phone", "");
        bio.put("Email", "");
        bio.put("Resume_Link","");
        bio.put("Educational","<p><font face=\"Arial\" size=\"4\"><b>Educational Information</b></font></p><p><br></p><p></p><p><font face=\"Segoe UI\" size=\"4\"><br></font></p>");
        bio.put("Professional","<p><font face=\"Arial\" size=\"4\"><b>Professional Experience</b></font></p><p><br></p><p></p><p><font face=\"Segoe UI\" size=\"4\"><br></font></p>");
        bio.put("Awards","<p><font face=\"Arial\" size=\"4\"><b>Awards</b></font></p><p><br></p><p></p><p><font face=\"Segoe UI\" size=\"4\"><br></font></p>");
        
        bio.put("Image_Ext","png");
        bio.put("Image_String", "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" );
       
        // JSONArray education = new JSONArray();
        
        /*for(int i=0;i<8;i++) {
        
        education.add("");
        }
        bio.put("Education", education);*/
        
        JSONArray ftpinfo = new JSONArray();
        
        ftpinfo.add("");
        ftpinfo.add("");
        ftpinfo.add("");
        
        bio.put("Server_Information",ftpinfo);
        
        /* JSONArray professional = new JSONArray();
        professional.add("Profession 1: ");
        professional.add("Profession 2: ");
        bio.put("Professional Experience:", professional);
        
        JSONArray awards = new JSONArray();
        awards.add("Award 1: ");
        awards.add("Award 2: ");
        bio.put("Honors & Awards:", awards);*/
        
        try (FileWriter file = new FileWriter("data.json")) {
            
	file.write(bio.toJSONString());
	}
        catch(IOException e) {
            
            JOptionPane.showMessageDialog(null,"Can't Create Data.json File. Please Check Your Directory Permission");
        }
    }
    
    private static void setDefaultHTML() {
        
        String htmlstr = "<html>\n" +
"<head>\n" +
"<title> $title </title>\n" +
"</head>\n" +
"<body>\n" +
"<h2>$name $initial</h2>\n" +
"<h3>$desig</h3>\n" +
"<h4>$department<br>$university</h4>\n" +
"\n" +
"<p align=\"center\"><img src=\"data:image/$type;base64,$imgStr\" ></p>\n" +
"<h4>Office Room: <i>$officeroom </i><br>Office Hours: <i>$officehours</i><br>Phone Number: <i>$phone</i><br>Email: <i>$email</i><br>Resume: <i>$resume</i></h4>\n" +
"\n" +
"\n" +
"<center><p><h2>Biography</h2></p></center>\n" +
"<p><h4>$biograph</h4></p>\n" +
"<hr>\n" +
"\n" +
"$educational\n" +
"\n" +
"$professional\n" +
"\n" +
"$awards\n" +
"\n" +
"</body>\n" +
"</html>";
        
        File newhtml;
        try {
                newhtml = new File("template.html");
                FileUtils.writeStringToFile(newhtml, htmlstr, "UTF-8");
                
            } catch (IOException e) {
                
                 JOptionPane.showMessageDialog(null,"Can't Create template.html File. Please Check Your Directory Permission");
                
            }
    }
    
}
