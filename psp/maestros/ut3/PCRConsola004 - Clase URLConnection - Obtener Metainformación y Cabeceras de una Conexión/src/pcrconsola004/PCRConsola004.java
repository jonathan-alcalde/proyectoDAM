package pcrconsola004;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class PCRConsola004 {

    public static void main(String[] args) {
        try {

            URL obj = new URL("https://www.youtube.com/");
            URLConnection conn = obj.openConnection();
            Map<String, List<String>> map = conn.getHeaderFields();

            System.out.println("Printing All Response Header for URL: " + obj.toString() + "\n");
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            System.out.println("\nGet Response Header By Key ...\n");
            List<String> xKinstaCache = map.get("X-Kinsta-Cache");
            if (xKinstaCache == null) {
                System.out.println("'X-Kinsta-Cache' doesn't present in Header!");
            } else {
                for (String header : xKinstaCache) {
                    System.out.println("X-Kinsta-Cache: " + header);
                }
            }

            System.out.println("\nGet Response Header By Key ...\n");
            List<String> contentLength = map.get("Content-Length");
            if (contentLength == null) {
                System.out.println("'Content-Length' doesn't present in Header!");
            } else {
                for (String header : contentLength) {
                    System.out.println("Content-Lenght: " + header);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
