/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.awt.CardLayout;
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
    
    JButton export,save,next,previous,finish,ftpexport;
    JButton personal_info,workplace_info,image_set,resume_link,educational,professional,awards;
    
    public void mainFrame() {
      
        previous = new JButton("Previous");
        previous.setBounds(30,520,110,30);
        next = new JButton("Next");
        next.setBounds(150,520,110,30);
        finish = new JButton("Finish");
        finish.setBounds(270,520,110,30);
        save = new JButton("Save all to Database");
        save.setBounds(390,520,150,30);
        export = new JButton("Export as HTML");
        export.setBounds(550,520,140,30);
        ftpexport = new JButton("Upload to FTP");
        ftpexport.setBounds(700,520,130,30);
        
        personal_info = new JButton("PERSONAL INFORMATION");
        personal_info.setBounds(30,50,200,40);
        image_set = new JButton("PICTURE");
        image_set.setBounds(30,110,200,40);
        workplace_info = new JButton("DESIGNATION AT UNIVERSITY");
        workplace_info.setBounds(30,170,200,40);
        resume_link = new JButton("RESUME");
        resume_link.setBounds(30,230,200,40);
        educational = new JButton("EDUCATION INFORMATION");
        educational.setBounds(30,290,200,40);
        professional = new JButton("PROFESSIONAL EXPERIENCE");
        professional.setBounds(30,350,200,40);
        awards = new JButton("ACHIEVED AWARDS");
        awards.setBounds(30,410,200,40);
        
        frame.add(export);
        frame.add(save);
        frame.add(next);
        frame.add(previous);
        frame.add(finish);
        frame.add(ftpexport);
        frame.add(personal_info);
        frame.add(image_set);
        frame.add(workplace_info);
        frame.add(resume_link);
        frame.add(educational);
        frame.add(professional);
        frame.add(awards);
        
        
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(870,600);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}
