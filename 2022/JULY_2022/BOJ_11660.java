import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long solution(int[][] arr, int x1, int y1, int x2, int y2) {
        if (x1 == 0 && y1 == 0) {
            return arr[x2][y2];
        }

        return arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st[j - 1]);
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1] + num ;

            }
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int x1 = Integer.parseInt(st[0]);
            int y1 = Integer.parseInt(st[1]);
            int x2 = Integer.parseInt(st[2]);
            int y2 = Integer.parseInt(st[3]);
            System.out.println(solution(arr, x1, y1, x2, y2));
        }
    }
}