package parcial2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String[] URLS = {};
    private static int instance = 0;

    public Connection(String[] urls) {
        URLS = urls;
    }

    public static StringBuffer connect(String value, String service) throws IOException {

        String url = RoundRobin(URLS);

        String final_url = url + service + "?value=" + value;
        URL obj = new URL(final_url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // The following invocation perform the connection implicitly before getting the
        // code
        StringBuffer response = new StringBuffer();
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return response;
    }

    private static String RoundRobin(String[] URLS) {
        if (instance < 1) {
            instance += 1;
            return URLS[instance];
        } else {
            instance = 0;
            return URLS[instance];
        }
    }

}
