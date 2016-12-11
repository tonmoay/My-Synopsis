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

import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.commons.net.ftp.*;

/**
 *
 * @author Tonmoay Deb
 *  
 */
public abstract class FTPUploader extends Variables {
    
    //This Class is a basic FTP upload wizard depending on Apache Commons Net Library.
    
    // This is a GUI that shows the display with JOptionPane on Parent Frame.
    
    public static void display() throws IOException {

        JTextField address = new JTextField(server);
        JTextField username = new JTextField(user);
        JPasswordField password = new JPasswordField(pass);
        JTextField directory = new JTextField(dir);


        JPanel panel = new JPanel(new GridLayout(10, 1));
        panel.add(new JLabel("Server Address:"));
        panel.add(address);
        panel.add(new JLabel("Username:"));
        panel.add(username);
        panel.add(new JLabel("Password:"));
        panel.add(password);
        panel.add(new JLabel("Upload Directory:"));
        panel.add(directory);

        int result;
        
        /*JOptionPane pane = new JOptionPane(panel,JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION);
        JDialog dialog = pane.createDialog(MotherFrame.mframe, "FTP Upload Wizard - My Synopsis");
        dialog.setSize(new Dimension(300,300));
        dialog.setVisible(true);*/
        
        result = JOptionPane.showConfirmDialog(MotherFrame.mframe, panel, "FTP Upload Wizard",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
        
        if (result == JOptionPane.OK_OPTION) {
            
            server = address.getText();
            user = username.getText();
            pass = new String(password.getPassword());
        //    System.out.println(pass);
            dir = directory.getText();
            
            JOptionPane.showMessageDialog(MotherFrame.mframe,"Press OK to start FTP Upload");
            
            HTMLWriter.writeHTML();
            
            JOptionPane.showMessageDialog(MotherFrame.mframe,uploadWizard());
            
        } else {
          //  System.out.println("Cancelled");
        }
    }
    
    //This Method is for Uploading the file. It returns upload result through a String.
    
    public static String uploadWizard() throws IOException  {
        
        FTPClient connect;
        connect = null;
        
        try {
            connect = new FTPClient();
            connect.connect(server, 21);
            int reply = connect.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                connect.disconnect();
                return "Can't Connect to the Server";
            }
            
            boolean check = connect.login(user, pass);
            if (!check) {
                return "Username or password Incorrect";
            }
            
            connect.setFileType(FTP.BINARY_FILE_TYPE);
            connect.enterLocalPassiveMode();
            
            InputStream input;
            try {
                input = new FileInputStream(new File("index.html"));
                connect.storeFile(dir + "index.html", input);
                input.close();
                connect.logout();
                connect.disconnect();
                
            } catch (IOException ex) {
                return "You need to put a slash (/) at the end";
            } 
        } catch (IOException iOException) {
            return "Wrong Server Information. Please Try again";
        }
        return "File Transfer Successful!";
    }
    
    
}
