import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long solution(long arr[], int m) {
        long count = 0;
        long[] remainder = new long[m];

        for (int i = 0; i < arr.length; i++) {
            int rslt = (int) (arr[i] % m);
            if (rslt == 0) {
                count++;
            }
            remainder[rslt]++;
        }

        for (int i = 0; i < m; i++) {
            if (remainder[i] > 1) {
                count = count + (remainder[i] * (remainder[i] - 1) / 2);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        long[] arr = new long[n];
        st = br.readLine().split(" ");
        arr[0] = Long.parseLong(st[0]);

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Long.parseLong(st[i]);
        }

        System.out.println(solution(arr, m));
    }
}