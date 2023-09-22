import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void solution() throws IOException {
    Set<Integer> s = new HashSet<>();
    int n = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    while (n-- > 0) {
      s.add(Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    while (m-- > 0) {
      if (s.contains(Integer.parseInt(st.nextToken()))) {
        sb.append("1\n");
      } else {
        sb.append("0\n");
      }
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}