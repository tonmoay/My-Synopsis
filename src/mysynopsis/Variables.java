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


/**
 *
 * @author Tonmoay Deb
 */
public abstract class Variables extends javax.swing.JFrame {
    
    //This Class contains all central variables which will be used for the project
    
    static String server="",user="",pass="",dir=""; // FTP Server Credentials
    
    //Faculty Details 
    static String name="",initial="",biog="",
            designation="",dept="",university="",universityAddress="",
            office="",officehours="",phone="",email="",resumelink="",
            education="",professional="",awards="";
    
    //Encoded Image Data
    static String imgExtension="", imgString="";
    
  //  static String[] educ = new String[8];
    
//    ArrayList<String> prof = new ArrayList<>();
   
    
}
