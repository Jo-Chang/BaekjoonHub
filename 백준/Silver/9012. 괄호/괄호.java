import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            sb.append(isVPS(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    String isVPS(String s) {
        if (s.length() == 0) return "YES";

        Stack<Character> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return "NO";
        return "YES";
    }

}