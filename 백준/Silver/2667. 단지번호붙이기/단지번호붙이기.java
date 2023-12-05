import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      for (int j = 0; j < n; j++) {
        arr[i][j] = input.charAt(j) - '0';
      }
    }
    br.close();

    ArrayList<Integer> list = new ArrayList<>();
    int[][] arr2 = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (arr[i][j] == 1 && arr2[i][j] == 0) {
          int cnt = 0;
          Deque<Integer> q = new LinkedList<>();
          q.push(i);
          q.push(j);
          arr2[i][j] = 1;
          while (!q.isEmpty()) {
            int y = q.pop();
            int x = q.pop();
            cnt++;
            for (int[] dt : delta) {
              int nx = x + dt[0];
              int ny = y + dt[1];
              if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (arr[nx][ny] == 1 && arr2[nx][ny] == 0) {
                  arr2[nx][ny] = 1;
                  q.push(nx);
                  q.push(ny);
                }
              }
            }
          }
          list.add(cnt);
        }
      }
    }
    Collections.sort(list);
    sb.append(list.size()).append("\n");
    for (int member : list) sb.append(member).append("\n");
    System.out.println(sb);
  }
}