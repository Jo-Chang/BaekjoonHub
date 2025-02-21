import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        int n = read(), m = read(), a = read(), h = read();
        int ans = 1;

        for (int i = 1; i < n; i++) {
            ans = (int) (((long) ans * m) % MOD);
        }

        System.out.println(ans);
    }
    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c&15;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

}