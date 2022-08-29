import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] arr;
    static int count;
    static boolean[][] visited;

    public static void bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Location(x, y));

        while (!queue.isEmpty()) {
            Location loc = queue.poll();
            int i = loc.x;
            int j = loc.y;

            for (int k = 0; k < 4; k++) {
                int nx = i + dx[k];
                int ny = j + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (arr[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        arr[nx][ny] = arr[i][j] + 1;
                        queue.add(new Location(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        count = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }

    static class Location {
        int x, y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}