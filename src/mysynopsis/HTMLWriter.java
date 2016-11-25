/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.*;
/**
 *
 * @author Personal
 */
public class HTMLWriter extends JSONReader {
    
    public void exportHTML() throws IOException{
        
        File htmlfile;
        htmlfile = new File("template.html");
        String htmlstr;
        htmlstr = FileUtils.readFileToString(htmlfile, "UTF-8");
        
        htmlstr = htmlstr.replace("$title",name);
        htmlstr = htmlstr.replace("$name",name);
        htmlstr = htmlstr.replace("$desig",designation);
        htmlstr = htmlstr.replace("$department",dept);
        htmlstr = htmlstr.replace("$university",university);
        htmlstr = htmlstr.replace("$officeroom",office);
        htmlstr = htmlstr.replace("$offcicehours",officehours);
        htmlstr = htmlstr.replace("$phone",phone);
        htmlstr = htmlstr.replace("$email",email);
        htmlstr = htmlstr.replace("$resume",resumelink);
        htmlstr = htmlstr.replace("$biograph",biog);
        
        File newhtml;
        newhtml = new File("index.html");
        FileUtils.writeStringToFile(newhtml, htmlstr, "UTF-8");
        
    }
    
}
