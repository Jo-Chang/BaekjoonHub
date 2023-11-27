import java.util.*;

class Solution {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int TC = sc.nextInt();

    for (int testcase = 1; testcase <= TC; testcase++) {
      int answer = 0;

      // 두 가지 경우를 합침
      // 1. 펠린드롬인 경우
      // 2. 펠린드롬이 아니나 합치면 펠린드롬이 되는 경우
      // + 같은 모양의 펠린드롬도 합칠 수 있음

      int N = sc.nextInt(), M = sc.nextInt();
      List<String> words = new ArrayList<>();
      int pelindromeCount = 0;
      for (int i = 0; i < N; i++) {
        String str = sc.next();
        String removeWord = "";

        boolean flag = true;
        if (isPelindrome(str)) pelindromeCount++;
        for (String word : words) {
          if (isPlusPelindrome(word, str)) {
            answer += 2 * M;
            removeWord = word;
            flag = false;
            break;
          }
          
        }
        if (flag) words.add(str);
        else words.remove(removeWord);
      }
      if (pelindromeCount > 0) answer += M;

      sb.append(String.format("#%d %d\n", testcase, answer));
    }

    System.out.println(sb);
    sc.close();
  }

  static boolean isPelindrome(String str) {
    for (int i = 0; i < str.length() / 2; i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
    }
    return true;
  }

  static boolean isPlusPelindrome(String word1, String word2) {
    for (int i = 0; i < word1.length(); i++) {
      if (word1.charAt(i) != word2.charAt(word2.length() - 1 - i)) return false;
    }
    return true;
  }
}
