import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currWeight = 0;
        int idx = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (idx != truck_weights.length) {
            // 다리를 다 지나면 queue에서 트럭을 뺴고 weight 에서도 빼준다.
            if (queue.size() == bridge_length) {
                currWeight -= queue.poll();
            }

            // 건널 수 있는 무게를 초과한 경우 0을 넣어주고, 시간을 1초 더해준다.
            else if (currWeight + truck_weights[idx] > weight) {
                queue.offer(0);
                answer++;
            }

            // 트럭을 넣을 수 있는 경우
            else {
                queue.offer(truck_weights[idx]);
                currWeight += truck_weights[idx++];
                answer++;
            }
        }

        // 마지막 남은 트럭까지 처리
        return answer + bridge_length;
    }
}