class Solution {
    public String solution(String a, String b) {
        String answer = "";
        int idx = 0, lenA = a.length(), lenB = b.length();
        boolean isRound = false;
        
        while (idx < lenA && idx < lenB) {
            int num = a.charAt(lenA - 1 - idx) + b.charAt(lenB - 1 - idx) - '0' * 2;
            
            if (isRound) {
                num++;
                isRound = false;
            }
            
            if (num > 9) {
                num -= 10;
                isRound = true;
            }
            
            answer = String.valueOf(num) + answer;
            
            idx++;
        }
        
        while (idx < lenA) {
           int num = a.charAt(lenA - 1 - idx) - '0';
            
            if (isRound) {
                num++;
                isRound = false;
            }
            
            if (num > 9) {
                num -= 10;
                isRound = true;
            }
            
            answer = String.valueOf(num) + answer;
            
            idx++;
        }
        
        while (idx < lenB) {
            int num = b.charAt(lenB - 1 - idx) - '0';
            
            if (isRound) {
                num++;
                isRound = false;
            }
            
            if (num > 9) {
                num -= 10;
                isRound = true;
            }
            
            answer = String.valueOf(num) + answer;
            
            idx++;
        }
        
        if (isRound) answer = "1" + answer;
        
        return answer;
    }
}