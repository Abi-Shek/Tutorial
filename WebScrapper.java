//=================================================================//
package webscrapper01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import webscrapper01.grabber.util.Grabber;

/**
 *
 * @author admin
 */
public class WebScrapper {

   
    public static void main(String[] args) {
        try{
            
            Grabber grabber=new Grabber();
                String content=grabber.grab("http://leapfrog.academy/course");
//        URL url=new URL("http://leapfrog.academy/course");
//            URLConnection conn=url.openConnection();
//            BufferedReader reader=new BufferedReader( new InputStreamReader(conn.getInputStream()));
//            StringBuilder content=new StringBuilder();
//            String line="";
//            while((line=reader.readLine())!=null){
//                content.append(line).append("\n");
            
            
           
            String RegEx= "<a href=\"(.*?)\" class=\"track\"(.*?)\">\\n\\s(.*?)</span>\\n(.*?)<h5>(.*?)</h5>";
                Pattern pattern = Pattern.compile(RegEx);
                Matcher matcher=pattern.matcher(content);
                while(matcher.find()){
                    System.out.println("TITLE");
                    System.out.println(matcher.group(5));
                    System.out.println("LINK");
                    System.out.println(matcher.group(1));
                    String link=matcher.group(1);
                    System.out.println("Crawling " + link);
                    System.out.println(grabber.grab(link));
                    System.out.println("==============================>");
                    
                
                }
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        
        
    }
    
}
//=============================================================================//