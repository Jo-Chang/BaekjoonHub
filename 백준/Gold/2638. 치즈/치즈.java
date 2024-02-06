import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj2638().sol();
  }
}

class Boj2638 {
  final int[][] DELTA = {
    { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
  };

  final int SPACE = 0;
  final int CHEESE = 1;
  final int MELTING = 2;
  final int OUTSIDE = 3;

  int N, M;
  int[][] arr;

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 입력
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    boolean noCheese = true;
    Arrays.fill(arr[0], OUTSIDE);
    Arrays.fill(arr[N - 1], OUTSIDE);
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());    
        if (arr[i][j] == CHEESE) {
          noCheese = false;
        }
      }

      arr[i][0] = arr[i][M - 1] = OUTSIDE;
    }
    br.close();

    int answer = 0;
    if (!noCheese) {
      while (true) {
        // printArr();
        // 치즈 내에 공간 확인 bfs -> 외부 공기 타일 체크
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            if (arr[i][j] != OUTSIDE) continue;
    
            q.add(i);
            q.add(j);
    
            while (!q.isEmpty()) {
              int x = q.remove();
              int y = q.remove();
              
              for (int[] dt : DELTA) {
                int nx = x + dt[0];
                int ny = y + dt[1];
                if (isOutside(nx, ny)) continue;
                if (arr[nx][ny] == SPACE) { 
                  arr[nx][ny] = OUTSIDE;
                  q.add(nx);
                  q.add(ny);
                }
              }
            }
          }
        }
    
        // 외부와 접촉된 치즈 확인
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            if (arr[i][j] != CHEESE) continue;
            
            int cnt = 0;
            for (int[] dt : DELTA) {
              int nx = i + dt[0];
              int ny = j + dt[1];
              if (isOutside(nx, ny)) continue;
              
              if (arr[nx][ny] == OUTSIDE) cnt++;
              if (cnt > 1) {
                arr[i][j] = MELTING;
                break;
              }
            }
            
          }
        }
    
        // printArr();
        boolean flag = true; // 녹지 않은 치즈가 남아있는지 확인
        // 접촉 치즈 지우고 반복
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
            if (arr[i][j] == MELTING) arr[i][j] = OUTSIDE;
            if (arr[i][j] == CHEESE) flag = false;
          }
        }
  
        answer++;
        if (flag) break; // 치즈가 남아있지 않으면 반복 종료
      }
    }

    System.out.println(answer);
  }

  boolean isOutside(int nx, int ny) {
    return (nx < 0 || nx >= N || ny < 0 || ny >= M);
  }

  class Location {
    int x, y;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  void printArr() {
    System.out.println("Print!");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }
}