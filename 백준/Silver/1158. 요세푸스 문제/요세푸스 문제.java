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
        StringBuilder sb = new StringBuilder();

        int n = read(), k = read(), cnt = 1;
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        IntStream.range(1, n + 1).forEach(x -> q.add(x));

        while (!q.isEmpty()) {
            int num = q.poll();
            if (cnt % k != 0) q.add(num);
            else result.add(num);
            cnt++;
        }

        sb.append("<").append(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            sb.append(", ").append(result.get(i));
        }
        sb.append(">");

        System.out.println(sb);
    }
    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c&15;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

}