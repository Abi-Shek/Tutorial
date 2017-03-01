//==================================================================================//
package webscrapper01.grabber.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author admin
 */
public class Grabber {
    public String grab(String link)throws IOException{
        
        
        
          URL url=new URL(link);
            URLConnection conn=url.openConnection();
            BufferedReader reader=new BufferedReader( new InputStreamReader(conn.getInputStream()));
            StringBuilder content=new StringBuilder();
            String line="";
            while((line=reader.readLine())!=null){
                content.append(line).append("\n");
    }
            reader.close();
            return content.toString();
}
}
