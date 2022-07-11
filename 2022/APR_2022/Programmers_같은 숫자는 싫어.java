import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> numbers = new ArrayList<>();
        int prev = arr[0];
        numbers.add(prev);

        for (int i = 1; i < arr.length; i++) {
            if (prev != arr[i]) {
                prev = arr[i];
                numbers.add(prev);
            }
        }

        answer = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            answer[i] = numbers.get(i);
        }

        return answer;
    }
}