import java.util.HashSet;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] cntArr = new char[26];
        
        for (char ch: s.toCharArray()) {
            cntArr[ch - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] == 1) answer += (char)('a' + i);
        }
        
        return answer;
    }
}