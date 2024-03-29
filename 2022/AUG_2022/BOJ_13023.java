import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb;
    static boolean[] visited;

    public static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(" ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr[V][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[x][y] = 1;
        }

        dfs(V);
        sb.append("\n");

        System.out.println(sb);
    }


}