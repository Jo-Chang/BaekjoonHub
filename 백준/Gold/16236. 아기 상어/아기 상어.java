import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    int[][] delta = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    }, arr;
    int n;

    class Pos implements Comparable<Pos> {
        int x, y, w;

        Pos() {}

        Pos(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Pos p) {
            if (this.w == p.w) {
                if (x == p.x) return y - p.y;
                return x - p.x;
            }
            return w - p.w;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        n = read();
        arr = new int[n][n];

        int ans = 0, sharkSize = 2, feedCount = 0;
        Pos cur = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = read();
                if (arr[i][j] == 9) {
                    cur = new Pos(i, j, 0);
                    arr[i][j] = 0;
                }
            }
        }

        while (true) {
            int move = findNextFish(cur, sharkSize);

            if (move == 0) break;

            ans += move;
            feedCount++;
            if (feedCount == sharkSize) {
                sharkSize++;
                feedCount = 0;
            }
        }

        System.out.println(ans);
    }

    int read() throws IOException {
        int c, n = 0;
        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
        if (c == 13) System.in.read();
        return n;
    }

    int findNextFish(Pos pos, int size) {
        int move = 0;
        Queue<Pos> q = new ArrayDeque<>();
        Queue<Pos> pq = new PriorityQueue<>();
        q.add(new Pos(pos.x, pos.y, 0));
        boolean[][] visit = new boolean[n][n];
        visit[pos.x][pos.y] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (move > 0 && cur.w > move) break;

            for (int[] dt : delta) {
                int nx = cur.x + dt[0], ny = cur.y + dt[1];
                if (!isInside(nx, ny) || visit[nx][ny]) continue;

                int nw = arr[nx][ny];

                if (0 < nw && nw < size) {
                    move = cur.w + 1;
                    pq.add(new Pos(nx, ny, move));
                    visit[nx][ny] = true;
                } else if (nw == 0 || nw == size){
                    q.add(new Pos(nx, ny, cur.w + 1));
                    visit[nx][ny] = true;
                }
            }
        }

        if (!pq.isEmpty()) {
            Pos p = pq.poll();
            pos.x = p.x;
            pos.y = p.y;
            move = p.w;
            arr[p.x][p.y] = 0;
        }

        return move;
    }

    boolean isInside(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}