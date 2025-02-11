import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    class Runner implements Comparable<Runner> {
        String name;
        double startTime, time, totalRecord;

        public Runner(String name, double startTime, double time) {
            this.name = name;
            this.startTime = startTime;
            this.time = time;
            this.totalRecord = 0;
        }

        @Override
        public int compareTo(Runner r) {
            if (time > r.time) return 1;
            return -1;
        }

        @Override
        public String toString() {
            return "Runner{" +
                    "name='" + name + '\'' +
                    ", startTime=" + startTime +
                    ", time=" + time +
                    ", totalRecord=" + totalRecord +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] selectedIdx = new int[4];
        Runner[] runners = new Runner[n];
        double newRecord = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            runners[i] = new Runner(
                    st.nextToken(),
                    Double.parseDouble(st.nextToken()),
                    Double.parseDouble(st.nextToken())
            );
        }

        Arrays.sort(runners);

        for (int i = 0; i < n; i++) {
            runners[i].totalRecord = runners[i].startTime;

            int[] temp = new int[3];
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                runners[i].totalRecord += runners[j].time;
                temp[cnt++] = j;
                if (cnt == 3) break;
            }

            if (runners[i].totalRecord < newRecord) {
                newRecord = runners[i].totalRecord;
                selectedIdx[0] = i;
                for (int j = 0; j < temp.length; j++) {
                    selectedIdx[j + 1] = temp[j];
                }
            }
        }

        sb.append(runners[selectedIdx[0]].totalRecord).append("\n");
        for (int i = 0; i < selectedIdx.length; i++) {
            sb.append(runners[selectedIdx[i]].name).append("\n");
        }

        System.out.println(sb);
    }

}