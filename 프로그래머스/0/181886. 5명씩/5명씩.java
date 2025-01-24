class Solution {
    public String[] solution(String[] names) {
        int groupNum = (names.length - 1) / 5 + 1;
        String[] answer = new String[groupNum];
        
        for (int i = 0; i < groupNum; i++) {
            answer[i] = names[i * 5];
        }
        
        return answer;
    }
}