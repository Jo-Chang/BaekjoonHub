import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        int ans = 0, sum = 0, n = read(), m = read(), k = read();
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) arr[i] = read();

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum >= m * k) {
                ans  = i + 1;
                break;
            }
        }

        System.out.println(ans < 1 ? "STRESS" : ans);
    }

    int read() throws IOException {
        boolean minus = false;
        int c = System.in.read(), n = 0;
        if (c == '-') minus = true;
        else n = c & 15;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
        if (c == 13) System.in.read();
        return n * (minus ? -1 : 1);
    }

}