import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < st.length; j++) {
                if (st[j].equals("1")) {
                    union(i, j);
                }
            }
        }

        String[] st = br.readLine().split(" ");
        boolean flag = true;
        int num = find(Integer.parseInt(st[0]) - 1);

        for (int i = 1; i < st.length; i++) {
            int find = find(Integer.parseInt(st[i]) - 1);
            if (num != find) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        }

        else {
            System.out.println("NO");
        }
    }
}