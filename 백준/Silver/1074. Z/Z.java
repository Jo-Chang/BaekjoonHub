import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  int readInt() throws IOException {
    int n = 0;

    while (true) {
      int input = System.in.read();
      if (input <= 32) {
        //  입력이 공백인 경우
        return n;
      } else {
        n = (n << 3) + (n << 1) + (input & 15);
      }
    }
  }

  void solution() throws IOException {
    int n = readInt(), r = readInt(), c = readInt();
    
    // int side = (int)Math.pow(2, n);
    // fill array
    // int[][] arr = new int[side][side];
    // fillArray(arr, 0, 0, 0, n - 1);
    // System.out.println(arr[r][c]);
    
    int answer = findValue(n, r, c, 0);
    System.out.println(answer);
  }

  void fillArray(int[][] arr, int x, int y, int num, int depth) {
    // 배열을 채워서 찾는 방식
    // 메모리 초과 발생
    if (depth == 0) {
      arr[x][y] = num;
      arr[x][y + 1] = num + 1;
      arr[x + 1][y] = num + 2;
      arr[x + 1][y + 1] = num + 3;
    } else {
      fillArray(arr, x, y, num, depth - 1);
      num += (int)Math.pow(2, depth) * (int)Math.pow(2, depth);
      fillArray(arr, x, y + (int)Math.pow(2, depth), num, depth - 1);
      num += (int)Math.pow(2, depth) * (int)Math.pow(2, depth);
      fillArray(arr, x + (int)Math.pow(2, depth), y, num, depth - 1);
      num += (int)Math.pow(2, depth) * (int)Math.pow(2, depth);
      fillArray(arr, x + (int)Math.pow(2, depth), y + (int)Math.pow(2, depth), num, depth - 1);
    }
  }


  int findValue(int n, int r, int c, int num) {
    if (n == 0) {
      return num;
    } else {
      int biNum = (int)Math.pow(2, n - 1);
      int flagRow = 0, flagCol = 0;

      if (r >= biNum) {
        flagRow = 1;
        r -= biNum;
      }
      if (c >= biNum) {
        flagCol = 1;
        c -= biNum;
      }
      num += biNum * biNum * flagRow * 2 + biNum * biNum * flagCol;
      return findValue(n - 1, r, c, num);
    }
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}