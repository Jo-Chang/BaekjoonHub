import java.io.*;
import java.util.*;

public class Main {
  int N, M;
  StringBuilder sb;
  Map<String, String> map;

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  void solution() throws IOException {
    sb = new StringBuilder();
    map = new HashMap<>();
    
    input();
    print();
  }

  void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      map.put(st.nextToken(), st.nextToken());
    }
    for (int i = 0; i < M; i++) {
      String domain = br.readLine();
      sb.append(find(domain)).append("\n");
    }

    br.close();
  }

  String find(String domain) {
    // if (!map.containsKey(domain)) return ERROR;
    return map.get(domain);
  }

  void print() throws IOException {
    System.out.println(sb);
  }
}