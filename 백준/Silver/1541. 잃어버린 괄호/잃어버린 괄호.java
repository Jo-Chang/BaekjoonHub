import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0;
    String input = br.readLine();

    boolean flag = false;
    int num = 0;
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
        num = num * 10 + (input.charAt(i) - '0');
      } else {
        if (flag) num *= -1;
        answer += num;
        if (input.charAt(i) == '-') flag = true;
        num = 0;
      }
    }
    if (flag) num *= -1;
    answer += num;
    br.close();

    System.out.println(answer);
  }
}