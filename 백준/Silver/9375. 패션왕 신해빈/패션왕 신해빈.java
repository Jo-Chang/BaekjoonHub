import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      int N = Integer.parseInt(br.readLine());
      Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < N; i++) {
        String[] input = br.readLine().split(" ");
        map.put(input[1], map.getOrDefault(input[1], 1) + 1);
      }
      int answer = 1;
      for (int cnt : map.values()) {
        answer *= cnt;
      }

      sb.append(--answer + "\n");
    }
    br.close();

    System.out.println(sb);
  }
}