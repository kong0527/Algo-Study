class Solution {
    public int solution(String s) {
        for (int i = s.length(); i >= 2; i--) {
            for (int j = 0; j < i + j; j++) {
                boolean flag = true;
                if (i + j > s.length()) {
                    break;
                }
                int left = j;
                int right = j + i - 1;
                while (left <= right) {
                    if (s.charAt(left++) != s.charAt(right--)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        
        return 1;
    }
    
    public boolean isPalindrome(String st) {
        int idx = st.length() - 1;
        
        for (int i = 0; i < st.length() / 2; i++) {
            if (st.charAt(i) != st.charAt(idx)) {
                return false;
            }
            idx--;
        }
        
        return true;
    }
}