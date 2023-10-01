import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  String myRead() throws IOException {
    String word = "";
    char ch = (char)(br.read());

    while (ch != '.') {
      word += String.valueOf(ch);
      ch = (char)(br.read());
    }

    return word.strip();
  }

  boolean isBalanced(String word) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == '(' || word.charAt(i) == '[') {
        s.push(word.charAt(i));
      } else if (word.charAt(i) == ')') {
        if (s.empty() || s.pop() != '(') {
          return false;
        }
      } else if (word.charAt(i) == ']') {
        if (s.empty() || s.pop() != '[') {
          return false;
        }
      }
    }

    if (s.empty()) return true;
    else return false;
  }

  void solution() throws IOException {
    // String word = myRead();
    String word = br.readLine();

    // while (word.length() > 0) {
    while (!word.equals(".")) {
      if (isBalanced(word)) {
        sb.append("yes\n");
      } else {
        sb.append("no\n");
      }

      // word = myRead();
      word = br.readLine();
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}