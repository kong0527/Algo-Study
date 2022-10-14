import java.util.ArrayList;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();
        long fn = 1;
        for (int i = 1; i <= n; i++) {
            arr.add(i);
            fn *= i;
        }
        k--;

        int i = 0;
        while (n > 0) {
            fn /= n;
            answer[i++] = arr.get((int) (k / fn));
            arr.remove((int) (k / fn));
            k %= fn;
            n--;
        }

        return answer;
    }
}