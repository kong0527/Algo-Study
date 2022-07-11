import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        for (int i = sorted.length - 1; i >= 0; i--) {
            answer += sorted[i];
        }

        return answer;
    }
}