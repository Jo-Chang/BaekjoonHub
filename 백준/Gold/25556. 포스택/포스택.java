import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        int n = read();
        boolean flag = true;
        Stack<Integer>[] stacks = new Stack[4];
        for (int i = 0; i < 4; i++) stacks[i] = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = read();
            flag = true;

            for (int j = 0; j < 4; j++) {
                if (stacks[j].isEmpty() || stacks[j].peek() < num) {
                    stacks[j].add(num);
                    flag = false;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        System.out.println(flag ? "NO" : "YES");
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