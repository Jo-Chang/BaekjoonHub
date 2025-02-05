import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        long n = readLong();
        int b = readInt();

        System.out.println(n <= (long) Math.pow(2, b + 1) - 1 ? "yes" : "no");
    }

    int readInt() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
        if (c == 13) System.in.read();
        return n;
    }

    long readLong() throws IOException {
        int c;
        long n = 0;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
        if (c == 13) System.in.read();
        return n;
    }


}