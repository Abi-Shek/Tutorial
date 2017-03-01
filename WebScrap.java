/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author admin
 */
public class WebScrap {

    

    public static void main(String[] args) {
        

try{
    String pathfile;
    pathfile = "E:/new.txt";
    BufferedReader reader=new BufferedReader(new FileReader(pathfile));
    String line="";
    while((line=reader.readLine())!=null){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+line);
        URL url = new URL(line);
      URLConnection conn = url.openConnection();
      
        BufferedReader readurl =new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String lineurl="";
        StringBuilder content = new StringBuilder();
      while((lineurl= readurl.readLine()) !=null) {
       content.append(lineurl).append("\n");
                 
      }String regEx="<a href=\"(.*?)\" class=\"track\"(.*?)\">\\n\\s(.*?)</span>\\n(.*?)<h5>(.*?)</h5>";
                
       Pattern pattern = Pattern.compile(regEx);
        
      Matcher matcher = pattern.matcher(content.toString());
      while(matcher.find()){
          String link=(matcher.group(1));
          System.out.println(" LINK ==>  " + link);
          String title =matcher.group(5);
          System.out.println("TITLE :==> " + title);
        
      }
      
      
      readurl.close();
    }
    
    
}catch(IOException ioe){
    System.out.println(ioe.getMessage());        
    }
    
}
    
}
