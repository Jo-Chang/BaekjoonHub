import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = read();

        while (n-- > 0) {
            int num = read();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        System.out.println(map.getOrDefault(read(), 0));
    }

    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c & 15;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

}