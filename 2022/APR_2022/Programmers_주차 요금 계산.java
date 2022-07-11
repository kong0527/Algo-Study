import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();

        // 차 번호별로 출입기록 hashMap에 저장
        for (String st : records) {
            String[] rec = st.split(" ");
            int carNum = Integer.parseInt(rec[1]);
            ArrayList<String> value;
            if (hashMap.containsKey(carNum)) {
                value = hashMap.get(carNum);
            }

            else {
                value = new ArrayList<>();
            }
            value.add(rec[0] + " " + rec[2]);
            hashMap.put(Integer.parseInt(rec[1]), value);
        }
        answer = new int[hashMap.size()];

        // 차 번호인 key를 오름차순으로 정렬
        Object[] keySet = hashMap.keySet().toArray();
        Arrays.sort(keySet);
        int idx = 0;

        for (Object key : keySet) {
            // 차 번호별 총 주차해놓은 시간을 저장할 변수
            int time = 0;
            ArrayList<String> arrayList = hashMap.get(key);
            while (arrayList.size() > 1) {
                String in = arrayList.remove(0).split(" ")[0];
                String out = arrayList.remove(0).split(" ")[0];
                // in과 out의 시간 계산
                int hour = Integer.parseInt(out.substring(0, 2)) - Integer.parseInt(in.substring(0, 2));
                int minute = Integer.parseInt(out.substring(3, 5)) - Integer.parseInt(in.substring(3, 5));
                time += hour * 60 + minute;
            }

            // arrayList 크기가 홀수인 경우 (출차 기록이 하나 없는 경우) 23시 59분에서 빼준다.
            if (!arrayList.isEmpty()) {
                String in = arrayList.get(arrayList.size()-1).split(" ")[0];
                int hour = 23 - Integer.parseInt(in.substring(0, 2));
                int minute = 59 - Integer.parseInt(in.substring(3, 5));
                time += hour * 60 + minute;
            }

            // 기본시간보다 작으면 그냥 기본요금
            if (time <= fees[0]) {
                answer[idx++] = fees[1];
            }

            // 크면 계산법에 따라 계산해준다.
            else {
                answer[idx++] = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }
        }

        return answer;
    }
}