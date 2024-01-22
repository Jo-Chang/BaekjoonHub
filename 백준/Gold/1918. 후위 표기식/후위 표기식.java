import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1918().sol();
  }
}

class Boj1918 {
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String infix = br.readLine();
    br.close();

    System.out.println(infixToPostfix(infix));
  }

  String infixToPostfix(String infix) {
    Stack<Character> s = new Stack<>();
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < infix.length(); i++) {
      char ch = infix.charAt(i);
      switch (ch) {
        case '+': case '-':
        if (!s.empty()) {
          while (s.peek() == '+' || s.peek() == '-' || s.peek() == '*' || s.peek() == '/') {
            sb.append(s.pop());
            if (s.empty()) break;
          }
        }
        s.push(ch);
        break;

        case '*': case'/':
        if (!s.empty()) {
          while (s.peek() == '*' || s.peek() == '/') {
            sb.append(s.pop());
            if (s.empty()) break;
          }
        }
        s.push(ch);
        break;

        case '(':
        s.push(ch);
        break;

        case ')':
        while (s.peek() != '(') {
          sb.append(s.pop());
        }
        s.pop(); // stack에서 '(' 제거
        break;

        default:
        sb.append(ch);
        break;
      }
    }

    while (!s.empty()) sb.append(s.pop());

    return sb.toString();
  }
}