import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        long answer = 0;
        int n = read(), digit = 1;
        int[] parity = new int[20];

        for (int i = 0; i < n; i++) {
            int num = read(), idx = 0;
            while (num > 0) {
                parity[idx++] += num & 1;
                num >>= 1;
            }
        }

        for (int i = 0; i < parity.length; i++) {
            answer += (long) digit * parity[i] * (n - parity[i]);
            digit <<= 1;
        }

        System.out.println(answer);
    }

    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c & 15;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

}