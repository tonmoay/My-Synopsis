/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

/**
 *
 * @author Personal
 */
public class MySynopsis extends FTPUploader{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here     
         
        /* JSONInit.initSystem();
        HTMLWriter html = new HTMLWriter();
        html.readData();
        html.exportHTML();*/
        
        FTPUploader launch = new FTPUploader();
        launch.mainFrame();
    }
    
}
