import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int n : arr) {
            numbers.add(n);
        }
        Arrays.sort(arr);
        numbers.remove((Object) arr[0]);

        if (numbers.size() == 0) {
            return new int[]{-1};
        }

        answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }
        return answer;
    }
}