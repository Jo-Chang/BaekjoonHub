import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        int n = read(), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = read();
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(min + " " + max);
    }

    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c&15;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

}