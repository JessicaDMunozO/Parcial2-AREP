package parcial2;

import static spark.Spark.*;

public class ServiceProxy {
    public static void main(String... args) {
        staticFiles.location("/public");

        String[] urls = {"http://localhost:4567/", "http://localhost:4567/"};
        Connection connection = new Connection(urls);

        port(getPort());

        get("hello", (req, res) -> "Hello Docker!");

        get("factors", (req, res) -> {
            String num_factors = req.queryParams("value");
            return connection.connect(num_factors, "factors");
        });

        get("primes", (req, res) -> {
            String num_primes = req.queryParams("value");
            return connection.connect(num_primes, "primes");
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}