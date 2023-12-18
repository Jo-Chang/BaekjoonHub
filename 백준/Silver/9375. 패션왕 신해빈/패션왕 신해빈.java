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
        if (map.containsKey(input[1])) {
          map.replace(input[1], map.get(input[1]) + 1);
        } else {
          map.put(input[1], 1);
        }
      }
      int answer = 1;
      for (int cnt : map.values()) {
        answer *= cnt + 1;
      }

      sb.append(--answer + "\n");
    }
    br.close();

    System.out.println(sb);
  }
}