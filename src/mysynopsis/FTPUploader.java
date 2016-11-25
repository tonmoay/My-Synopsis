/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.*;

/**
 *
 * @author Personal
 */
public class FTPUploader extends HTMLWriter {
    
    public String uploadWizard() throws IOException  {
        FTPClient connect = new FTPClient();
        connect.connect(server,21);
        int reply = connect.getReplyCode();
        if(!FTPReply.isPositiveCompletion(reply)) {
            connect.disconnect();
            return "Can't Connect to the Server";
	}
        
        boolean check = connect.login(user, pass);
        if(!check) {
            return "Username or password Incorrect";
        }
        
        connect.setFileType(FTP.BINARY_FILE_TYPE);
        connect.enterLocalPassiveMode();
        
        InputStream input;
        try {
            input = new FileInputStream(new File("index.html"));
            connect.storeFile(dir+"index.html", input);
        } catch (FileNotFoundException ex) {
            return "index.html file not available.";
        }
        finally {
        connect.logout();
        connect.disconnect();
    }
        return "File Transfer Successful!";
    }
}
