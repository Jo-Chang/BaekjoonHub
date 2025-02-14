import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        int n = read();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = read();
            arr[i][1] = read();
        }

        System.out.printf("%.1f", getArea(arr));
    }

    double getArea(int[][] arr) {
        long area = 0;
        int[] prev = arr[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            area += ((long) prev[0] + arr[i][0]) * (prev[1] - arr[i][1]);
//            area += (long) prev[0] * arr[i][1] - (long) arr[i][0] * prev[1];
            prev = arr[i];
        }

        return (double) Math.abs(area) / 2;
    }

    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c & 15;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        if (c == 13) System.in.read();

        return n * minus;
    }

}