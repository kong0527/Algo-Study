import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 이름별로 인덱스를 저장할 맵
        HashMap<String, Integer> index = new HashMap<>();
        // 사용자별 신고횟수를 담을 맵
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 신고 기록중 중복된 내용을 거르기 위한 셋
        Set<String> tmp = new HashSet<>(Arrays.asList(report));
        // 중복된 내용을 거른 셋을 다시 배열로 변환
        String[] arr = tmp.toArray(new String[0]);
        // 신고를 k번 이상 받아 정지된 사용자 목록
        Set<String> suspend = new HashSet<>();

        // 맵에 사용자 이름과 인덱스를 저장한다.
        for (int i = 0; i < id_list.length; i++) {
            index.put(id_list[i], i);
        }

        for (String st : arr) {
            // 사용자별 신고횟수 정리
            String reported = st.split(" ")[1];
            if (hashMap.containsKey(reported)) {
                int value = hashMap.get(reported) + 1;
                hashMap.put(reported, value);
            }

            else {
                hashMap.put(reported, 1);
            }

            // k번 이상 신고당한 사용자는 셋에 담는다.
            if (hashMap.get(reported) >= k) {
                suspend.add(reported);
            }
        }

        for (String st : arr) {
            // 신고자가 메일 받은 횟수를 계산
            String reporter = st.split(" ")[0];
            String reported = st.split(" ")[1];
            if (suspend.contains(reported)) {
                answer[index.get(reporter)] += 1;
            }
        }

        return answer;
    }
}