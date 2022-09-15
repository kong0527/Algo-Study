import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] group;
    static StringBuilder sb;
    static boolean isEven;

    public static void dfs(int node) {
        visited[node] = true;

        for (int i : arr[node]) {
            if (!visited[i]) {
                group[i] = (group[node] + 1) % 2;
                dfs(i);
            }

            else if (group[node] == group[i]) {
                isEven = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            isEven = true;
            group = new int[V + 1];

            for (int j = 0; j <= V; j++) {
                arr[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                arr[node1].add(node2);
            }

            for (int j = 1; j <= V; j++) {
                if (isEven) {
                    dfs(j);
                }

                else {
                    break;
                }
            }

            if (isEven) {
                sb.append("YES").append("\n");
            }

            else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}