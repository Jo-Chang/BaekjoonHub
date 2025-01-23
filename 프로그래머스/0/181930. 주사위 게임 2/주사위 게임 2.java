class Solution {
    public int solution(int a, int b, int c) {
        int answer = a + b + c;
        
        if (a == b || b == c || c == a) {
            answer *= a * a + b * b + c * c;
            
            if (a == b && b == c) answer *= Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3);
        }
        
        return answer;
    }
}