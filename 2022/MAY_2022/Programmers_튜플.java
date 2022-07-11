import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        // 맨 앞의 {와 맨 뒤의 }} 제거
        String[] split = s.substring(1, s.length() - 2).split("},");

        for (int i = 0; i < split.length; i++) {
            String[] tmp = split[i].substring(1).split(",");
            ArrayList<String> arr = new ArrayList<>();
            Collections.addAll(arr, tmp);
            hashMap.put(tmp.length, arr);
        }

        // ArrayList 크기로 오름차순 정렬
        Object[] keys = hashMap.keySet().toArray();
        Arrays.sort(keys);
        ArrayList<String> ans = new ArrayList<>();

        for (Object key : keys) {
            ArrayList<String> arr = hashMap.get(key);
            if (arr.size() > 1) {
                for (int i = 0; i < ans.size(); i++) {
                    arr.remove(ans.get(i));
                }
            }
            ans.add(arr.get(0));
        }

        answer = new int[ans.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(ans.get(i));
        }

        return answer;
    }
}