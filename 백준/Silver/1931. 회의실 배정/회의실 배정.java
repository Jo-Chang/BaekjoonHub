import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  int answer = 0;

  // 동적 프로그래밍 방법, 시간 초과
  void solution() throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[][] list = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      list[i][0] = Integer.parseInt(st.nextToken());
      list[i][1] = Integer.parseInt(st.nextToken());
    }


    int[][] dp = new int[n][3];
    // 2차원에서 dp[i][0] -> start, dp[i][1] -> end, dp[i][2] -> 동적 프로그래밍
    for (int i = 0; i < n; i++) {
      dp[i][0] = list[i][0];
      dp[i][1] = list[i][1];

      int maxIdx = i;
      for (int j = 0; j < i; j++) {
        if ((dp[j][0] >= list[i][1] || dp[j][1] <= list[i][0]) && dp[j][2] > dp[maxIdx][2]) {
          maxIdx = j;
        }
      }

      if (maxIdx != i) {
        dp[i][2] = dp[maxIdx][2] + 1;
        dp[i][0] = Math.min(dp[i][0], dp[maxIdx][0]);
        dp[i][1] = Math.max(dp[i][1], dp[maxIdx][1]);
      } else {
        dp[i][2] = 1;
      }
    }

    answer = dp[n - 1][2];
    System.out.println(answer);
  }

  // 그리디 알고리즘
  // LiinkedList와 Pair(Custom Class) 버전
  void solution2() throws IOException {
    int n = Integer.parseInt(br.readLine());
    LinkedList<Pair> list = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int start, end;

      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());

      // list->firsts가 start를 포함한다면
      // last값을 비교하여 더 작은 last 값으로 교체
      boolean flag = true;
      for (Pair p : list) {
        if (p.getStart() == start) {
          p.setEnd(Math.min(p.getEnd(), end));
          flag = false;
          break;
        }
      }
      if (flag) {
       list.add(new Pair(start, end)); 
      }
    }

    Collections.sort(list);

    int curEnd = 0;
    for (Pair p: list) {
      if (p.getStart() >= curEnd) {
        curEnd = p.getEnd();
        answer++;
      }
    }

    System.out.println(answer);
  }

  class Pair implements Comparable<Pair> {
    private int x;
    private int y;

    public Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getStart() {
      return this.x;
    }

    public int getEnd() {
      return this.y;
    }

    public void setEnd(int y) {
      this.y = y;
    }

    @Override
    public int compareTo(final Pair o) {
      if (y == o.y) return Integer.compare(x, o.x);
      return Integer.compare(y, o.y);
    }
  }

  // 그리디 알고리즘
  // 단순 배열 정렬 버전
  void solution3() throws IOException {
    int n = Integer.parseInt(br.readLine());

    int[][] time = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      time[i][0] = Integer.parseInt(st.nextToken());
      time[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(time, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
        return o1[1] - o2[1];
        // 같은 코드
        // return (o1[1] < o2[1]) ? -1 : ((o1[1] == o2[1]) ? 0 : 1);
        // return Integer.compare(o1[1], o2[1]);
      }
    });

    int end = 0;
    for (int i = 0; i < n; i++) {
      if (time[i][0] >= end) {
        end = time[i][1];
        answer++;
      }
    }

    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution3();
  }
}