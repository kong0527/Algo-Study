import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> answer;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        dfs("ICN", "ICN", 0, tickets);
        // 사전순으로 정렬
        Collections.sort(answer);

        // 알파벳으로 제일 앞서는 경로를 return
        return answer.get(0).split(" ");
    }

    public void dfs(String now, String nodes, int count, String[][] tickets) {
        // 모든 티켓을 사용했다면 해당 경로를 answer에 저장
        if(count == tickets.length) {
            answer.add(nodes);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            // 아직 방문하지 않은 곳이고 사용할 수 있는 티켓이면 방문
            if(!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                dfs(tickets[i][1], nodes + " " + tickets[i][1],count+1, tickets);
                visited[i] = false;
            }
        }
    }
}