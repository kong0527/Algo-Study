import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int node;

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        visited[y][x] = true;

        for (int i = 1; i <= node; i++) {
            if (!visited[y][i] && arr[y][i] == 1) {
                dfs(y, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1][node + 1];
        count = 0;

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        // 자기 자신도 연결 요소에 포함해줘야함!!
        for (int i = 1; i <= node; i++) {
            arr[i][i] = 1;
        }

        for (int i = 1; i <= node; i++) {
            for (int j = 1; j <= node; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }
}