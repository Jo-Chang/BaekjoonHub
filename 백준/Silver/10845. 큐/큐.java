import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void solution() throws IOException {
    LinkedList<String> q = new LinkedList<>();

    int n = Integer.parseInt(br.readLine());

    while (n-- >0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();

      switch(cmd) {
        case "push":
        q.add(st.nextToken());
        break;

        case "pop":
        sb.append(q.isEmpty()? -1 : q.removeFirst()).append("\n");
        break;

        case "size":
        sb.append(q.size()).append("\n");
        break;
        
        case "empty":
        sb.append(q.isEmpty()? 1 : 0).append("\n");
        break;

        case "front":
        sb.append(q.isEmpty()? -1 : q.peekFirst()).append("\n");
        break;
        
        case "back":
        sb.append(q.isEmpty()? -1 : q.peekLast()).append("\n");
        break;
      }
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}