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

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.apache.commons.net.util.Base64;

/**
 *
 * @author Tonmoay Deb
 * 
 * This Class is about Image Encoding & Decoding of BASE64 Encoded Image
 * 
 */
public class ImageProcess extends Variables {
    
    /*public static String encodeToString(BufferedImage image, String type) {
    String imageString;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    
    try {
    ImageIO.write(image, type, bos);
    byte[] imageBytes = bos.toByteArray();
    
    
    
    imageString = DatatypeConverter.printBase64Binary(imageBytes);
    
    bos.close();
    } catch (IOException e) {
    return null;
    }
    return imageString;
    }*/
    
    //Gets File Path & Returns BASE64 String Value
    
    public static String toImageString(String path) throws FileNotFoundException, IOException {
   
        String imageString = "";
        try {
            File f = new File(path);
            try (FileInputStream fis = new FileInputStream(f)) {
                byte byteArray[] = new byte[(int) f.length()];
                fis.read(byteArray);
                imageString = Base64.encodeBase64String(byteArray);
                fis.close();
            }
        } catch (IOException iOException) {
            
            return "";
        }
        
        
        return imageString;
    }
    
    //Returns A BufferedImage from BASE64 String.
    
    public static BufferedImage toBufferedImage() throws IOException {
        
        BufferedImage bufferedImage = null;
        try {
            byte[] byteArray = Base64.decodeBase64(imgString);
            
            try (InputStream in = new ByteArrayInputStream(byteArray)) {
                bufferedImage = ImageIO.read(in);
            }
            
        } catch (IOException iOException) {
            
            return null;
        }
        
        return bufferedImage;
    }
    
  
}