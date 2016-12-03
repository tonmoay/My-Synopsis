/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Personal
 */
public class MySynopsis extends FTPUploader{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException{
        // TODO code application logic here     
         
        /* JSONInit.initSystem();
        HTMLWriter html = new HTMLWriter();
        html.readData();
        html.exportHTML();*/
        
        FTPUploader launch = new FTPUploader();
        launch.mainFrame();
        launch.readData();
        launch.exportHTML();
    }
    
}
