/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Personal
 */
public class Frames  {
    
    String server="",user="",pass="",dir="";
    String name="",biog="",designation="",dept="",university="",office="",officehours="",phone="",email="",resumelink="";
    ArrayList<String> educ = new ArrayList<>();
    ArrayList<String> prof = new ArrayList<>();
    
    JFrame frame = new JFrame("My Synopsis");
    JPanel one = new JPanel();
    JPanel two = new JPanel();
    JPanel main = new JPanel();
    CardLayout layout = new CardLayout();
    
    JButton export = new JButton("Export to HTML");
    JButton save = new JButton("Save to Database");
    JButton next = new JButton("Next");
    JButton previous = new JButton("Previous");
    JButton finish = new JButton("Finish");
    JButton ftpexport = new JButton("Upload to FTP");
    
    
    public void mainFrame() {
        
        
        frame.add(main);
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
