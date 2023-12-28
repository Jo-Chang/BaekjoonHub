import java.io.*;
import java.util.*;

public class Main {
  TreeMap<Integer, Integer> map;
  StringBuilder sb;

  public static void main(String[] args) throws IOException {
    new Main().solution();  
  }

  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      int k = Integer.parseInt(br.readLine());
      map = new TreeMap<>();
      for (int i = 0; i < k; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());

        char cmd = st.nextToken().charAt(0);
        int num = Integer.parseInt(st.nextToken());
        if (cmd == 'I') {
          map.put(num, map.getOrDefault(num, 0) + 1);
        } else if (cmd == 'D') {
          if (map.size() == 0) continue;

          int key = num == 1 ? map.lastKey() : map.firstKey();
          if (map.put(key, map.get(key) - 1) == 1) map.remove(key);
        }
      }
      sb.append(map.isEmpty() ? "EMPTY" : String.format("%d %d", map.lastKey(), map.firstKey())).append("\n");
    }
    br.close();
    
    System.out.println(sb);
  }
}