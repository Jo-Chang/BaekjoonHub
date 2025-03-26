import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();

        Arrays.sort(arr);
        int left = 0, right = n - 1, idx1 = -1, idx2 = -1, sum = Integer.MAX_VALUE;
        while (left < right) {
            int newSum = Math.abs(arr[left] + arr[right]);
            if (newSum < sum) {
                idx1 = left;
                idx2 = right;
                sum = newSum;
            }
            if (sum == 0) break;

            if (Math.abs(arr[left]) > Math.abs(arr[right])) left++;
            else right--;
        }

        System.out.println(arr[idx1] + " " + arr[idx2]);
    }

    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c & 15;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

}