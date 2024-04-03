package parcial2;

import static spark.Spark.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class MathService {

    public static void main(String... args) {
        port(getPort());

        get("hello", (req, res) -> "Hello Docker!");

        get("factors", (req, res) -> {
            String num_factors = req.queryParams("value");

            // response
            JSONArray response = factors(Integer.parseInt(num_factors));

            JSONObject responseJson = new JSONObject();
            responseJson.put("operation", "factors");
            responseJson.put("input", num_factors);
            responseJson.put("output", response);

            return responseJson;
        });

        get("primes", (req, res) -> {
            String num_primes = req.queryParams("value");

            // response
            JSONArray response = primes(Integer.parseInt(num_primes));

            JSONObject responseJson = new JSONObject();
            responseJson.put("operation", "primes");
            responseJson.put("input", num_primes);
            responseJson.put("output", response);

            return responseJson;
        });
    }

    private static JSONArray factors(Integer num_factors) {
        JSONArray array = new JSONArray();

        int n = 1;

        int limit = num_factors / 2;
        while (n <= limit) {
            if (num_factors % n == 0) {
                array.put(n);
            }
            n += 1;
        }

        array.put(num_factors);

        return array;
    }

    private static JSONArray primes(Integer num_primes) {
        JSONArray array = new JSONArray();

        int n = 2;

        while (n <= num_primes) {
            JSONArray facArray = factors(n);
            if (facArray.length() == 2) {
                array.put(n);
            }
            n += 1;
        }

        return array;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
