import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().sol();
    }

    void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] arr = new char[m][n];
        int answer = 0;

        for (int i = 0; i < m; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line[j];
            }
        }

        for (int i = 1; i < m; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '.' && arr[i - 1][j] == 'X') cnt++;
                else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }

            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'X' && arr[i - 1][j] == '.') cnt++;
                else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (arr[j][i] == '.' && arr[j][i - 1] == 'X') cnt++;
                else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }

            cnt = 0;
            for (int j = 0; j < m; j++) {
                if (arr[j][i] == 'X' && arr[j][i - 1] == '.') cnt++;
                else {
                    answer += cnt / 2;
                    cnt = 0;
                }
            }
        }

        System.out.println(answer);
    }

}
