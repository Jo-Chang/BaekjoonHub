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
    int n = readInt(), m = readInt(), b = readInt();
    int max = 0, min = 256, answerTime = Integer.MAX_VALUE, answerHeight = 0;

    int[][] land = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        land[i][j] = readInt();
        if (land[i][j] > max) max = land[i][j];
        if (land[i][j] < min) min = land[i][j];
      }
    }

    // 1. 모든 칸을 최소 높이로 맞춘다. (항상 가능)
    // 2. 모든 칸을 최대 높이로 맞춘다. (남은 블록이 부족할 수 있음)
    // 3. 일정 높이 이상의 높이의 땅을 깎아서 낮은 높이에 더함.
    // -> 기준 : 인벤토리 내 블록이 부족할 때
    for (int h = min; h <= max; h++) {
      int time = 0;
      int block = b;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (land[i][j] > h) {
            time += (land[i][j] - h) * 2;
            block += land[i][j] - h;
          } else {
            time += h - land[i][j];
            block -= h - land[i][j];
          }
        }
      }

      if (block < 0) {
        break;
      }

      if (time <= answerTime) {
        answerTime = time;
        answerHeight = h;
      }
    }

    System.out.printf("%d %d", answerTime, answerHeight);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}