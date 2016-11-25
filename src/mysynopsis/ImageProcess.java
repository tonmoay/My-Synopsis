/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysynopsis;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Personal
 */
public class ImageProcess {
    
    public static String encodeToString(BufferedImage image, String type) {
        String imageString;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
 
        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
 
            /*BASE64Encoder encoder = new BASE64Encoder();*/
            /*imageString = encoder.encode(imageBytes);*/
            
            imageString = DatatypeConverter.printBase64Binary(imageBytes);
 
            bos.close();
        } catch (IOException e) {
            return null;
        }
        return imageString;
    }   
}