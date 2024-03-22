import java.io.*;
import java.util.*;

class Main {
  static StringBuilder sb;
  static int N;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    // Input
    N = Integer.parseInt(br.readLine());
    List<Node> list = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list.add(new Node(i + 1, Integer.parseInt(st.nextToken())));
    }
    br.close();

    int idx = 0;
    for (int i = 1; i < N; i++) {
      Node node = list.remove(idx);
      int size = list.size();
      sb.append(node.index).append(" ");
      
      if (node.value > 0) {
        idx = (idx + node.value - 1) % size;
      }
      else {
        idx = (idx + node.value % size + size) % size;
      }
    }
    sb.append(list.get(0).index);
    System.out.println(sb);
  }

  static class Node {
    int index, value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}
