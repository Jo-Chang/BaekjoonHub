class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        int len = pat.length();
        
        for (int i = myString.length(); i >= len; i--) {
            if (myString.substring(i - len, i).equals(pat)) {
                answer = myString.substring(0, i);
                break;
            }
        }
        
        return answer;
    }
}