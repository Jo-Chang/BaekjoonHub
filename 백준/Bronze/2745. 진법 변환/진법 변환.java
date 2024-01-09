import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1504().solution();
  }
}

class Boj1504 {
  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();

    String N = st.nextToken();
    int B = Integer.parseInt(st.nextToken());
    int num = 0;

    for (int i = 0; i < N.length(); i++) {
      num *= B;
      char ch = N.charAt(i);
      if ('0' <= ch && ch <= '9') num += (ch - '0');
      else if ('A' <= ch && ch <= 'Z') num += (10 + ch - 'A');
    }

    System.out.println(num);
  }
}

