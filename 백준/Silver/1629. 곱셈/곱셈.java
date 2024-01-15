import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1504().solution();
  }
}

class Boj1504 {
  int A, B, C;
  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long answer = 1;
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    answer = pow(A, B, C);

    System.out.println(answer);
  }

  long pow(int base, int exponent, int mod) {
    if (exponent == 1) return base % mod;

    long num = pow(base, exponent / 2, mod);

    return ((exponent % 2 == 0) ? (num * num % mod) : ((num * num % mod) * base % mod));
  }
}