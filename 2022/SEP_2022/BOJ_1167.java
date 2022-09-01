import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static boolean[] visited;
    static int V;
    static ArrayList<Edge>[] arr;
    static int[] distance;

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (Edge i : arr[curr]) {
                int e = i.e;
                int v = i.value;

                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[curr] + v;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        arr = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            String[] st = br.readLine().split(" ");
            int node = Integer.parseInt(st[0]);
            for (int j = 1; j < st.length - 1; j += 2) {
                int edge = Integer.parseInt(st[j]);
                int value = Integer.parseInt(st[j + 1]);
                arr[node].add(new Edge(edge, value));
            }
        }

        bfs(1);
        int max = 1;
        for (int i = 2; i <= V; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[V]);
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}