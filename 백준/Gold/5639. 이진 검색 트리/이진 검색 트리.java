import java.io.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj5639().sol();
  }
}

class Boj5639 {
  int[] tree;
  StringBuilder sb;
  
  {
    tree = new int[10001];
    sb = new StringBuilder();
  }

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    int idx = 0;
    while ((input = br.readLine()) != null && !input.isEmpty()) {
      int num = Integer.parseInt(input);
      tree[idx++] = num;
    }
    br.close();

    postTraversal(0, idx - 1);
    System.out.println(sb);
  }

  void postTraversal(int s, int e) {
    if (s > e) return;
    
    int root = s++;

    while (tree[s] < tree[root] && s <= e) s++;

    postTraversal(root + 1, s - 1);
    postTraversal(s, e);

    sb.append(tree[root]).append("\n");
  }
}
