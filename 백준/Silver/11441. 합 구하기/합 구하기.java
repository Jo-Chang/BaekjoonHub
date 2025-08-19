import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        arr.add(0);

        while (st.hasMoreElements())
            arr.add(Integer.parseInt(st.nextToken()));

        List<Integer> table = new ArrayList<>(Collections.nCopies(N + 1, 0));

        table.set(0, arr.get(0));

        for (int i = 1; i <= N; i++) {
            table.set(i, arr.get(i) + table.get(i - 1));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = table.get(end) - table.get(start - 1);

            System.out.println(result);
        }
    }

}