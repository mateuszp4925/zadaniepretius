import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "data.txt";
        if (args.length == 1) {
            filename = args[0];
        }

        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(filename));
            String line = file.readLine();

            double sum = 0.0;
            while (line != null) {
                Map<String, String> map = new LinkedHashMap<String, String>();
                for (String keyValue : line.split("@")) {
                    String[] pair = keyValue.split(":");
                    if (pair.length == 2) {
                        map.put(pair[0], pair[1]);
                    }
                }

                if (map.containsKey("amount")) {
                    String stringValue = map.get("amount");
                    double value = Double.parseDouble(stringValue.substring(0, stringValue.length() - 3).replaceAll(",", "."));
                    sum += value;
                }
                line = file.readLine();
            }
            System.out.format("%.2fPLN", sum);
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }
}