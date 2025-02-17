import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int lastNum = -1, cnt = 0, idx = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == lastNum) arr[i] = -1;
            else {
                cnt++;
                lastNum = arr[i];
            }
        }
        
        answer = new int[cnt];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) answer[idx++] = arr[i];
        }

        return answer;
    }
}