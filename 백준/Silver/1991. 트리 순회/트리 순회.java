import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1991().sol();
  }
}

class Boj1991 {
  Node[] tree;
  StringBuilder sb;

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    tree = new Node[N];
    for (int i = 0; i < N; i++) tree[i] = new Node();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      char p = st.nextToken().charAt(0);
      char l = st.nextToken().charAt(0);
      char r = st.nextToken().charAt(0);
      
      if (l != '.') {
        tree[getIdx(p)].left = getIdx(l);
      }
      if (r != '.') {
        tree[getIdx(p)].right = getIdx(r);
      }
    }
    br.close();

    prefixTraversal(0);
    sb.append("\n");
    infixTraversal(0);
    sb.append("\n");
    postfixTraversal(0);
    sb.append("\n");

    System.out.println(sb);
  }

  int getIdx(char ch) { return (ch - 'A'); }
  char getChar(int index) { return (char)('A' + index); }

  void prefixTraversal(int index) {
    sb.append(getChar(index));
    if (tree[index].left != 0) prefixTraversal(tree[index].left);
    if (tree[index].right != 0) prefixTraversal(tree[index].right);
  }
  void infixTraversal(int index) {
    if (tree[index].left != 0) infixTraversal(tree[index].left);
    sb.append(getChar(index));
    if (tree[index].right != 0) infixTraversal(tree[index].right);
  }
  void postfixTraversal(int index) {
    if (tree[index].left != 0) postfixTraversal(tree[index].left);
    if (tree[index].right != 0) postfixTraversal(tree[index].right);
    sb.append(getChar(index));
  }


  class Node {
    int left, right;
  
    void setLeft(int left) { this.left = left; }
    void setRight(int right) { this.right = right; }
  }
}
