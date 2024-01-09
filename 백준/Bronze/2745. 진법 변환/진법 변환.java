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

    for (int i = N.length() - 1; i >= 0; i--) {
      char ch = N.charAt(i);
      if ('0' <= ch && ch <= '9') num += (ch - '0') * Math.pow(B, N.length()-1 - i);
      else if ('A' <= ch && ch <= 'Z') num += (10 + ch - 'A') * Math.pow(B, N.length()-1 - i);
    }

    System.out.println(num);
  }
}

