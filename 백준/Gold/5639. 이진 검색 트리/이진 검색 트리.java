import java.io.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj5639().sol();
  }
}

class Boj5639 {
  StringBuilder sb;
  
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Node root = new Node(0);
    sb = new StringBuilder();

    String input = "";
    while ((input = br.readLine()) != null && !input.isEmpty()) {
      int num = Integer.parseInt(input);

      if (root.element == 0) root = new Node(num);
      else insertTree(root, num); 
    }
    br.close();

    postTraversal(root);
    System.out.println(sb);
  }

  void insertTree(Node node, int ele) {
    if (ele < node.element) {
      if (node.left == null) {
        node.left = new Node(ele);
      }
      else {
        insertTree(node.left, ele);
      }
    }
    else {
      if (node.right == null) {
        node.right = new Node(ele);
      }
      else {
        insertTree(node.right, ele);
      }
    }
  }

  void postTraversal(Node node) {
    if (node.left != null) postTraversal(node.left);
    if (node.right != null) postTraversal(node.right);
    sb.append(node.element).append("\n");
  }

  class Node {
    int element;
    Node left, right;
  
    Node(int element) {
      this.element = element;
    }
  }
}
