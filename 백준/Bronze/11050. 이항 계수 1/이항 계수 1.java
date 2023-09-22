import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    System.out.println(combination(n, k));
  }

  int combination(int n, int k) {
    int result = 1;

    for (int i = n; i > n - k; i--) {
      result *= i;
    }
    for (int i = 1; i <= k; i++) {
      result /= i;
    }

    return result;
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}