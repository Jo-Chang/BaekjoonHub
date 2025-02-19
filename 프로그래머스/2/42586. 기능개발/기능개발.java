import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        
        while (cnt < progresses.length) {
            int day = 0;
            
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] == 0) continue;
                progresses[i] += speeds[i];
            }
            
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] == 0) continue;
                else if (progresses[i] >= 100) {
                    day++;
                    progresses[i] = 0;
                    cnt++;
                }
                else break;
            }
            
            if (day > 0) ans.add(day);
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}