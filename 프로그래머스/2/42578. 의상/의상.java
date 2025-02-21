import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        
        for (String[] set: clothes) {
            map.put(set[1], map.getOrDefault(set[1], 0) + 1);
        }
        
         for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}