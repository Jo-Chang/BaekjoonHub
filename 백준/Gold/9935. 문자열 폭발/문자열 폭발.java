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
    char[] result = new char[str.length];
    int bSize = bomb.length;

    int idx = 0;
    for (int i = 0; i < str.length; i++) {
      result[idx++] = str[i];

      if (idx >= bSize) {
        boolean flag = true;
        for (int j = 0; j < bSize; j++) {
          if (bomb[j] != result[idx - bSize + j]) {
            flag = false;
            break;
          }
        }
        if (flag) {
          idx -= bSize;
        }
      }
    }

    if (idx == 0) return "FRULA";
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < idx; i++) sb.append(result[i]);
    return sb.toString();
  }
}