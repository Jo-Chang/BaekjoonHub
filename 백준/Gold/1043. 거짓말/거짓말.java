import java.io.*;
import java.util.*;
import java.util.stream.IntStream;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1043().solution();
  }
}

class Boj1043 {
  int N, M;
  Set<Integer> truth, truthParent;
  List<Integer>[] party;
  int[] parent;

  void solution() throws IOException {
    int answer = 0;

    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    party = new ArrayList[M];
    parent = IntStream.rangeClosed(0, N).toArray();
    truth = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    for (int i = 0; i < num; i++) {
      truth.add(Integer.parseInt(st.nextToken()));
    }
    for (int i = 0; i < M; i++) {
      party[i] = new ArrayList<>();
      st = new StringTokenizer(br.readLine());

      num = Integer.parseInt(st.nextToken());
      int firstPerson = Integer.parseInt(st.nextToken());
      party[i].add(firstPerson);
      for (int j = 1; j < num; j++) {
        int person = Integer.parseInt(st.nextToken());
        party[i].add(person);
        union(firstPerson, person);
      }
    }

    truthParent = new HashSet<>();
    for (int mem : truth) {
      truthParent.add(find(mem));
    }

    for (int i = 0; i < M; i++) {
      int pa = find(party[i].get(0));
      if (!truthParent.contains(pa)) answer++;
    }

    br.close();
    System.out.println(answer);
  }

  int find(int e) {
    if (parent[e] == e) return e;
    return find(parent[e]);
  }

  void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a > b) parent[a] = b;
    else parent[b] = a;
  }
}