import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }

        else {
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return true;
        }

        else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int answer = 0;
        ArrayList<Integer>[] party = new ArrayList[m];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        String[] truth = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            String[] st = br.readLine().split(" ");
            party[i] = new ArrayList<>();
            for (int j = 1; j < st.length; j++) {
                party[i].add(Integer.parseInt(st[j]));
            }
        }

        for (int i = 0; i < m; i++) {
            int first = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first, party[i].get(j));
            }
        }

        for (int i = 0; i < m; i++) {
            boolean flag = true;
            int curr = party[i].get(0);
            for (int j = 0; j < truth.length; j++) {
                if (find(curr) == find(Integer.parseInt(truth[j]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}