import java.util.HashMap;

class Solution {
    HashMap<Integer, String> map = new HashMap<>();
    
    {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
    }
    
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < 10; i++) {
            s = s.replace(map.get(i), String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}