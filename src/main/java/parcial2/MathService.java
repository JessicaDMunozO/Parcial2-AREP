package parcial2;

import static spark.Spark.*;

import org.json.JSONArray;

public class MathService {

    public static void main(String... args) {
        port(getPort());

        get("hello", (req, res) -> "Hello Docker!");

        get("factors", (req, res) -> {
            String num_factors = req.queryParams("value");
            return factors(Integer.parseInt(num_factors));
        });

        get("primes", (req, res) -> {
            String num_primes = req.queryParams("value");
            return primes(Integer.parseInt(num_primes));
        });
    }

    private static JSONArray factors(Integer num_factors) {
        JSONArray array = new JSONArray();
        array.put(1);
        
        int n = 2;

        int limit = num_factors / 2;
        while (n <= limit) {
            if (num_factors % n == 0) {
                array.put(n);
                n += 1;
            } 
        }

        array.put(num_factors);

        return array;
    }

    private static JSONArray primes(Integer num_primes) {
        JSONArray array = new JSONArray();
        JSONArray primes = new JSONArray();

        array.put(1);
        
        int n = 2;
        int j = 1;

        while (n <= num_primes) {
            while (j <= n) {
                if (n % j == 0) {
                    primes.put(j);
                    j += 1;
                }
            }
            if (primes.length() == 2) {
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
