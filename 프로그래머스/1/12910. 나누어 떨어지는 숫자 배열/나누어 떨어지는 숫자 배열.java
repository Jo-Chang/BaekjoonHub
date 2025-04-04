import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList list = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) list.add(arr[i]);
        }

        if (list.size() == 0) {
            answer = new int[]{ -1 };
        } else {
            answer = list.stream().mapToInt(x -> (int) x).toArray();
            Arrays.sort(answer);    
        }
        
        return answer;
    }
}