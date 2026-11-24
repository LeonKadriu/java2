import java.io.BufferedReader;
import java.io.InputStreamReader;

class IO {
    static String readln() {
        try {
            var line = new BufferedReader(new InputStreamReader(System.in)).readLine();
            return line == null ? "" : line;
        } catch (Exception e) {
            return "";
        }
    }
}
