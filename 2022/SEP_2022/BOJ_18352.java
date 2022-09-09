import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int N, M, X, start;
    static ArrayList<Integer>[] arr;
    static int[] visited;

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node]++;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : arr[curr]) {
                if (visited[i] == -1) {
                    visited[i] = visited[curr] + 1;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        arr = new ArrayList[N + 1];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        Arrays.fill(visited, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr[node1].add(node2);
        }

        bfs(start);

        for (int i = 0; i <= N; i++) {
            if(visited[i] == X) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        if (answer.isEmpty()) {
            System.out.println(-1);
        }

        else {
            for (int num : answer) {
                System.out.println(num);
            }
        }
    }
}