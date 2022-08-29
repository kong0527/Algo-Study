import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static boolean isArrive;

    public static void dfs(int curr, int depth) {
        if (depth == 5) {
            isArrive = true;
            return ;
        }

        visited[curr] = true;

        for (int i : arr[curr]) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[curr] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        isArrive = false;
        arr = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (isArrive) {
                break;
            }
        }

        if (isArrive) {
            System.out.println("1");
        }

        else {
            System.out.println("0");
        }
    }
}