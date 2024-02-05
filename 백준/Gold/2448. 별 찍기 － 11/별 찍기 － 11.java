import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj2448().sol();
  }
}

class Boj2448 {
  StringBuilder sb;
  boolean[][] tree;

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    tree = new boolean[N][N * 2];
    br.close();

    makeTree(N, 0, 0);
    printTree();

  }
  
  void makeTree(int n, int x, int y) {
    if (n == 3) {
      tree[x][y + 2] = true;
      tree[x + 1][y + 3] = true;
      tree[x + 1][y + 1] = true;
      for (int i = 0; i < 5; i++) {
        tree[x + 2][y + i] = true;
      }
    } 
    else {
      makeTree(n / 2, x, y + n / 2);
      makeTree(n / 2, x + n / 2, y);
      makeTree(n / 2, x + n / 2, y + n);
    }
  }
  
  void printTree() {
    for (int i = 0; i < tree.length; i++) {
      for (int j = 0; j < tree[0].length; j++) {
        sb.append(tree[i][j] ? "*" : " ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

}