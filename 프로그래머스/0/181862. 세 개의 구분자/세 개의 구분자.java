class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        String[] strs = myStr.split("a|b|c");
        int cnt = 0;
        
        for (String str : strs) {
            if (!str.equals("")) cnt++;
        }
        
        if (cnt == 0) answer = new String[] {"EMPTY"};
        else {
            answer = new String[cnt];
            int idx = 0;
            
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].equals("")) {
                    answer[idx++] = strs[i];
                }
            }
        }
        
        return answer;
    }
}