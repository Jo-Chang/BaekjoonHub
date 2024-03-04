import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj9935().sol();
  }
}

class Boj9935 {
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    char[] original = br.readLine().toCharArray();
    char[] bomb = br.readLine().toCharArray();
    br.close();
    
    String answer = stringExplosion(original, bomb);

    System.out.println(answer);
  }

  String stringExplosion(char[] str, char[] bomb) {
    int bSize = bomb.length;

    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length; i++) {
      s.push(str[i]);

      if (s.size() >= bSize) {
        boolean flag = true;
        for (int j = 0; j < bSize; j++) {
          if (bomb[j] != s.get(s.size() - bSize + j)) {
            flag = false;
            break;
          }
        }
        if (flag) {
          for (int j = 0; j < bSize; j++) s.pop();
        }
      }
    }

    if (s.isEmpty()) return "FRULA";
    StringBuffer sb = new StringBuffer();
    for (char ch : s) sb.append(ch);
    return sb.toString();
  }
}