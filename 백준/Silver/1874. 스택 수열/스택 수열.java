import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void solution() throws IOException {
    int n = Integer.parseInt(br.readLine());
    LinkedList<Integer> stack = new LinkedList<>();
    ArrayList<Integer> orderedList = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      orderedList.add(i);
    }

    for (int i = 0; i < n; i++) {
      int num = Integer.parseInt(br.readLine());

      if (!stack.isEmpty() && stack.peekLast() == num) {
        stack.removeLast();
        sb.append("-\n");
      } else if (!orderedList.isEmpty() && orderedList.get(0) <= num) {
        int next = orderedList.remove(0);
        while (next != num) {
          stack.add(next);
          sb.append("+\n");
          next = orderedList.remove(0);
        }
        stack.add(next);
        sb.append("+\n");
        stack.removeLast();
        sb.append("-\n");
      } else {
        sb = new StringBuilder("NO");
        break;
      }
    }
    
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}