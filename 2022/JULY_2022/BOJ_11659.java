import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long solution(int[] arr, int s, int e) {
        if (s == 0) {
            return arr[e];
        }
        return arr[e] - arr[s - 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int[] arr = new int[n];
        st = br.readLine().split(" ");
        arr[0] = Integer.parseInt(st[0]);

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st[i]);
        }

        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int e = Integer.parseInt(st[1]);
            System.out.println(solution(arr, s - 1, e - 1));
        }
    }
}