import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = read(), p = read(), idx = 0;
        BigInteger result = new BigInteger(Integer.toString(n)).pow(p);
        String resultStr = result.toString();

        while (idx + 70 < resultStr.length()) {
            sb.append(resultStr.substring(idx, idx + 70)).append("\n");
            idx += 70;
        }

        sb.append(resultStr.substring(idx)).append("\n");

        System.out.println(sb);
    }

    int read() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
        if (c == 13) System.in.read();
        return n;
    }

}