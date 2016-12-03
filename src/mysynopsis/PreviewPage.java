/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;

/**
 *
 * @author Personal
 */
public class PreviewPage {
    
    public static void getSite() throws FileNotFoundException, IOException {
        JFrame preview = new JFrame("Preview My Site - My Synopsis");
        FileReader reader = new FileReader("index.html");
        JTextPane editor = new JTextPane();
        editor.setContentType( "text/html" );
        editor.setEditable( false );
        editor.read(reader, null);
        Document doc = editor.getDocument();
        JScrollPane scrollPane = new JScrollPane( editor );
        scrollPane.setPreferredSize( new Dimension(600, 600) );
        preview.getContentPane().add( scrollPane );
        preview.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        preview.pack();
        preview.setLocationRelativeTo( null );
        preview.setVisible(true);
    }
    
}