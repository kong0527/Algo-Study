class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += " ";
                idx = 1;
                continue;
            }
            
            if (idx % 2 == 1) {
                answer += Character.toString(s.charAt(i)).toUpperCase();
            }
            
            else {
                answer += Character.toString(s.charAt(i)).toLowerCase();
            }
            
            idx++;
        }
        
        return answer;
    }
}