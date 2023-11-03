import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  int answer = 0;
  final int MAXIMUM = 100000;

  void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
    // 그래프의 사용범위 최댓값은 max(N, K+1) 중 더 큰 값보다 더 큰 수 중 가장 가까운 2의배수이다.
    int max = Math.max(N, K + 1);
    while (max % 2 != 0) max++;
    if (max > MAXIMUM) max = MAXIMUM;
    ArrayList<Integer>[] list = new ArrayList[max + 1];

    for (int i = 0; i <= max; i++) list[i] = new ArrayList<>();

    list[0].add(1);
    for (int i = 1; i < max; i++) {
      list[i].add(i - 1);
      list[i].add(i + 1);
      if (i <= max / 2) list[i].add(i * 2);
    }
    list[max].add(max - 1);
    
    int[] dist = new int[max + 1];
    for (int i = 0; i <= max; i++) {
      dist[i] = -1;
    }
    LinkedList<Integer> q = new LinkedList<>();

    q.add(N);
    dist[N] = 0;
    while (!q.isEmpty()) {
      int cur = q.remove();
      
      if (cur == K) break;

      for (int mem : list[cur]) {
        int newDist = dist[cur] + 1;
        if (dist[mem] > newDist || dist[mem] == -1) {
          dist[mem] = newDist;
          q.add(mem);
        }
      }
    }

    answer = dist[K];
    System.out.println(answer);
  }

  void solution2() throws IOException {
     StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
    // 그래프의 사용범위 최댓값은 max(N, K+1) 중 더 큰 값보다 더 큰 수 중 가장 가까운 2의배수이다.
    int max = Math.max(N, K + 1);
    while (max % 2 != 0) max++;
    if (max > MAXIMUM) max = MAXIMUM;

    int[] dist = new int[max + 1];
    LinkedList<Integer> q = new LinkedList<>();

    dist[N] = 1;
    q.add(N);
    while (!q.isEmpty()) {
      int cur = q.remove();

      if (cur == K) break;

      int newDist = dist[cur] + 1;
      if (cur + 1 <= max && (dist[cur + 1] == 0 || dist[cur + 1] > newDist)) {
        dist[cur + 1] = newDist;
        q.add(cur + 1);
      } 
      if (cur - 1 >= 0 && (dist[cur - 1] == 0 || dist[cur - 1] > newDist)) {
        dist[cur - 1] = newDist;
        q.add(cur - 1);
      }
      if (cur * 2 <= max && (dist[cur * 2] == 0 || dist[cur * 2] > newDist)) {
        dist[cur * 2] = newDist;
        q.add(cur * 2);
      }
    }

    System.out.println(dist[K] - 1);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution2();
  }
}