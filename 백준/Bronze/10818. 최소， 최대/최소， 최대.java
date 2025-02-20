import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.printf(
                "%d %d",
                Arrays.stream(arr).min().getAsInt(),
                Arrays.stream(arr).max().getAsInt()
        );
    }

    int read() throws IOException {
        int c, n = 0;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n;
    }

}