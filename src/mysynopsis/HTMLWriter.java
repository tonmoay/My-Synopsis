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

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.*;
/**
 *
 * @author Tonmoay Deb 
 * 
 */
public abstract class HTMLWriter extends Variables {
    
    //This Class will write the string data to HTML
    
    public static String writeHTML() throws IOException{
        
        JSONWriter.writeData();
        
        File htmlfile = null;
        try {
            
            htmlfile = new File("template.html");
            String htmlstr;
            htmlstr = FileUtils.readFileToString(htmlfile, "UTF-8");
        //    System.out.println(htmlstr);
            
            htmlstr = htmlstr.replace("$type",imgExtension);
            htmlstr = htmlstr.replace("$imgStr",imgString);
            htmlstr = htmlstr.replace("$title",name);
            htmlstr = htmlstr.replace("$name",name);
            
            if(initial.length()>0) {
                htmlstr = htmlstr.replace("$initial","["+initial+"]");
            }
            else {
                htmlstr = htmlstr.replace("$initial",initial);
            }
            
            htmlstr = htmlstr.replace("$desig",designation);
            htmlstr = htmlstr.replace("$department",dept);
            htmlstr = htmlstr.replace("$university",university);
            htmlstr = htmlstr.replace("$officeroom",office);
            htmlstr = htmlstr.replace("$officehours",officehours);
            htmlstr = htmlstr.replace("$phone",phone);
            htmlstr = htmlstr.replace("$email",email);
            htmlstr = htmlstr.replace("$resume",resumelink);
            htmlstr = htmlstr.replace("$biograph",biog);
            htmlstr = htmlstr.replace("$educational",education);
            
            /*htmlstr = htmlstr.replace("$highschool", educ[0]);
            htmlstr = htmlstr.replace("$hsduration", educ[1]);
            htmlstr = htmlstr.replace("$college", educ[2]);
            htmlstr = htmlstr.replace("$clgduration", educ[3]);
            htmlstr = htmlstr.replace("$undergrad_degree", educ[4]);
            htmlstr = htmlstr.replace("$undergradvarsity", educ[5]);
            htmlstr = htmlstr.replace("$grad_degree", educ[6]);
            htmlstr = htmlstr.replace("$gradvarsity", educ[7]);*/
            htmlstr = htmlstr.replace("$professional", professional);
        //    System.out.println(professional);
            htmlstr = htmlstr.replace("$awards", awards);
            
      //      JOptionPane.showMessageDialog(null,educ[1]);
      
            File newhtml;
            try {
                newhtml = new File("index.html");
                FileUtils.writeStringToFile(newhtml, htmlstr, "UTF-8");
                return "HTML Export Successful!!";
            } catch (IOException | HeadlessException e) {
                
                 return "An Error Occured. Please Restart the Application";
                
            }
        } catch (IOException e) {
            
            return "Template (template.html) File Not Found!";
        }
        
        
    }
    
}
