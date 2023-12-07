import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int testcase = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcase; tc++) {
      String cmd = br.readLine();
      int n = Integer.parseInt(br.readLine());
      Deque<Integer> deq = new LinkedList<>();
      String arrayString = br.readLine();
      if (n > 0) {
        int num = 0;
        for (int i = 0; i < arrayString.length(); i++) {
          int input = arrayString.charAt(i);
          if (input >= '0' && input <= '9') {
            num = num * 10 + (input - '0');
          } else if (input == ',' || input == ']') {
            deq.add(num);
            num = 0;
          }
        }
      }
      
      boolean reverseFlag = false;
      boolean errorFlag = false;
      for (int i = 0; i < cmd.length(); i++) {
        if (cmd.charAt(i) == 'R') {
          reverseFlag = !reverseFlag;
        } else if (cmd.charAt(i) == 'D') {
          if (deq.isEmpty()) {
            sb.append("error\n");
            errorFlag = true;
            break;
          } else {
            if (reverseFlag) {
              deq.removeLast();
            } else {
              deq.removeFirst();
            }
          }
        }
      }

      if (!errorFlag) {
        sb.append("[");
        while (!deq.isEmpty()) {
          if (reverseFlag) {
            sb.append(deq.removeLast());
          } else {
            sb.append(deq.removeFirst());
          }

          if (!deq.isEmpty()) sb.append(",");
        }
        sb.append("]\n");
      }
    }
    br.close();
    System.out.println(sb.toString());
  }
}