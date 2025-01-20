class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        String sum = "";
        int len = strArr.length;
        
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].contains("ad")) {
                continue;
            }
            
            if (!sum.isEmpty()) sum += " ";
            sum += strArr[i];
        }
        
        answer = sum.split(" ");
        
        return answer;
    }
}