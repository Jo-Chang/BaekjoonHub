import java.io.*;
import java.util.*;

public class Main {
  void solution1() throws Exception {
    Scanner sc = new Scanner(System.in);
    int answer = 0;
    int n = sc.nextInt(), m = sc.nextInt();
    int[] brokens = new int[m];
    for (int i = 0; i < m; i++) {
      brokens[i] = sc.nextInt();
    }

    answer = Math.abs(n - 100);
    int num = n;
    while (num >= (n > 100 ? 100 : 0)) { 
      int num2 = num;

      int digit = 0;
      boolean flag = false;
      if (num2 == 0) {
        for (int broken : brokens) {
          if (broken == 0) {
            flag = true;
            break;
          }
        }
        digit = 1;
      } else {
        while (num2 > 0) {
          for (int broken : brokens) {
            if (broken == num2 % 10) {
              flag = true;
              break;
            }
          }
          if (flag) break;
          digit++;
          num2 /= 10;
        }
      }

      if (flag) num--;
      else {
        answer = Math.min(answer, n - num + digit);
        break;
      }
    }
    num = n;
    while (num <= n + Math.abs(n - 100)) {
      int num2 = num;

      int digit = 0;
      boolean flag = false;
      if (num2 == 0) {
        for (int broken : brokens) {
          if (broken == 0) {
            flag = true;
            break;
          }
        }
        digit = 1;
      } else {
        while (num2 > 0) {
          for (int broken : brokens) {
            if (broken == num2 % 10) {
              flag = true;
              break;
            }
          }
          if (flag) break;
          digit++;
          num2 /= 10;
        }
      }
      
      if (flag) num++;
      else {
        answer = Math.min(answer, num - n + digit);
        break;
      }
    }

    System.out.println(answer);
  }

	public static void main(String[] args) throws Exception {
    new Main().solution1();
  }
}