import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();
  int answer = 0;

  void solution() throws IOException {
    int tc = Integer.parseInt(br.readLine());

    Set<Integer> set = new HashSet<>();
    while (tc-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      String cmd = st.nextToken();
      int x;
      switch (cmd) {
        case "add":
          x = Integer.parseInt(st.nextToken());
          set.add(x);
          break;
        case "remove":
          x = Integer.parseInt(st.nextToken());
          set.remove(x);
          break;
        case "check":
          x = Integer.parseInt(st.nextToken());
          sb.append(set.contains(x) ? "1" : "0").append("\n");
          break;
        case "toggle":
          x = Integer.parseInt(st.nextToken());
          if (set.contains(x)) set.remove(x);
          else set.add(x);
          break;
        case "all":
          for (int i = 1; i <= 20; i++) {
            set.add(i);
          }
          break;
        case "empty":
          set.clear();
          break;
        default:
          System.out.printf("Wrong Input - %s\n", cmd);
          break;
      }
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}