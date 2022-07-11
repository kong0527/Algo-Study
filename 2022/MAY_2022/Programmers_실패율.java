import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int total = stages.length;
        int[] count = new int[N + 1];
        int idx = 0;
        HashMap<Double, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < stages.length; i++) {
            count[stages[i] - 1]++;
        }

        for (int i = 0; i < count.length - 1; i++) {
            double rate = (double) count[i] / total;
            if (count[i] == 0) {
                rate = 0;
            }
            total -= count[i];
            ArrayList<Integer> arr;
            if (hashMap.containsKey(rate)) {
                arr = hashMap.get(rate);
            }

            else {
                arr = new ArrayList<>();
            }
            arr.add(i + 1);
            hashMap.put(rate, arr);
        }

        Object[] keys = hashMap.keySet().toArray();
        Arrays.sort(keys);

        for (int i = keys.length - 1; i >= 0; i--) {
            ArrayList<Integer> arr = hashMap.get(keys[i]);
            if (arr.size() == 1) {
                answer[idx++] = arr.get(0);
            }

            else {
                Collections.sort(arr);
                for (int j = 0; j < arr.size(); j++) {
                    answer[idx++] = arr.get(j);
                }
            }
        }

        return answer;
    }
}