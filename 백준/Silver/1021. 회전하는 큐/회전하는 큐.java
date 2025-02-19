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
        int n = read(), m = read(), ans = 0;
        Deque<Integer> deq = new ArrayDeque();

        for (int i = 1; i <= n; i++) {
            deq.add(i);
        }

        for (int i = 0; i < m; i++) {
            int num = read(), cnt = 0;

            while (true) {
                int cur = (Integer) deq.remove();
                if (cur == num) break;
                deq.add(cur);
                cnt++;
            }

            ans += Math.min(cnt, deq.size() + 1 - cnt);
        }

        System.out.println(ans);
    }

    int read() throws IOException {
        int c, n = 0;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        if (c == 13) System.in.read();

        return n;
    }

}