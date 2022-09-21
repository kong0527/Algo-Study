import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] answer;
    static int n;
    static int[] time;
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        answer = new int[n + 1];
        time = new int[n + 1];
        degree = new int[n + 1];


        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }

                arr[num].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : arr[curr]) {
                degree[next]--;
                answer[next] = Math.max(answer[next], answer[curr] + time[curr]);

                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(answer[i] + time[i]);
        }
    }
}