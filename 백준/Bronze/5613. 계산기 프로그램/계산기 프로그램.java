import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        char cal = 'a';
        int answer = Integer.parseInt(br.readLine());
        while (!(line = br.readLine()).equals("=")) {
            char ch = line.charAt(0);
            if ('0' <= ch && ch <= '9') {
                int num = Integer.parseInt(line);
                if (cal == '+') answer += num;
                else if (cal == '-') answer -= num;
                else if (cal == '*') answer *= num;
                else if (cal == '/') answer /= num;
            } else {
                cal = ch;
            }
        }
        System.out.println(answer);
    }
}