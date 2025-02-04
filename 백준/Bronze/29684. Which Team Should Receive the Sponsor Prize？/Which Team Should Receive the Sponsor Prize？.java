import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while ((n = read()) > 0) {
            int closestNum = read(), closestIdx = 1;

            for (int i = 1; i < n; i++) {
                int num = read();
                if (Math.abs(2023 - num) < Math.abs(2023 - closestNum)) {
                    closestNum = num;
                    closestIdx = i + 1;
                }
            }

            sb.append(closestIdx).append("\n");
        }

        System.out.println(sb);
    }

    static int read() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
        if (c == 13) System.in.read();
        return n;
    }
}