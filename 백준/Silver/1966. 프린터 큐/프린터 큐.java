import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void heapPush(int[] q, int value) {
    int idx = 1;
    while (q[idx] != 0) idx++;
    q[idx] = value;

    while (idx > 1) {
      if (q[idx] > q[idx / 2]) {
        int temp = q[idx];
        q[idx] = q[idx / 2];
        q[idx / 2] = temp;
        idx /= 2;
      } else {
        break;
      }
    }
  }

  int heapPop(int[] q) {
    int max = q[1];
    int length = 1, idx = 1;

    while (q[length] != 0) length++;
    length--;
    if (length < 1) return -1;

    q[1] = q[length];
    q[length] = 0;

    int left = 2, right = 3;
    while (right < length) {
      if (q[left] <= q[idx] && q[right] <= q[idx]) break;
      else {
        if (q[left] > q[right]) {
          int temp = q[left];
          q[left] = q[idx];
          q[idx] = temp;
          idx = left;
        } else {
          int temp = q[right];
          q[right] = q[idx];
          q[idx] = temp;
          idx = right;
        }
        
        left = idx * 2;
        right = idx * 2 + 1;
      }
    }

    if (left < length && q[idx] < q[left]) {
      int temp = q[idx];
      q[idx] = q[left];
      q[left] = temp;
    }

    return max;
  }

  void solution() throws IOException {
    int t = Integer.parseInt(br.readLine());
    
    while (t-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int[] q = new int[n + 2];
      int[] orders = new int[n], origins = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        int num = Integer.parseInt(st.nextToken());
        origins[i] = num;
        heapPush(q, num);
      }

      // 프린터 큐에 남은 순서 계산
      // 1. 큐를 출력하기 전에 현재 수보다 더 큰 수가 있는지 계산
      // 1. => heapPop()에서 나온 수와 같은지 체크
      int order = 1, nextIdx = 0;
      while (order <= n) {
        int now = heapPop(q);

        while (origins[nextIdx] != now) {
          nextIdx = (nextIdx + 1) % n;
        }
        orders[nextIdx] = order;
        origins[nextIdx] = 0;

        order++;
      }

      sb.append(orders[m]).append("\n");
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}