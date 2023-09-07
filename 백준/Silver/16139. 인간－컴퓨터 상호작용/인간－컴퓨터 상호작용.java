import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String word = br.readLine();
    int q = Integer.parseInt(br.readLine());
    char ch;
    int l, r;

    int[][] cntArr = new int[word.length() + 1][26];  // 알파뱃 26문자
    Arrays.fill(cntArr[0], 0);
    for (int i = 1; i <= word.length(); i++) {
      for (int j = 0; j < 26; j++) {
        cntArr[i][j] = cntArr[i - 1][j];
      }
      cntArr[i][word.charAt(i - 1) - 'a']++;
    }

    while (q-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      ch = st.nextToken().charAt(0);
      l = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());

      System.out.println(cntArr[r + 1][ch - 'a'] - cntArr[l][ch - 'a']);
    }
  }  
}
