class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        long rslt = x;

        while (idx < n) {
            answer[idx++] = (long) rslt;
            rslt += x;
        }

        return answer;
    }
}