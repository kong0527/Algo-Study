import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;
    static int m;
    static int right;
    static int min;
    static int left;

    public static void solution() {
        int start = left;
        int end = right;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                min = Math.min(min, mid);
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }
    }

    public static boolean check(int time) {
        int s = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (s + arr[i] <= time) {
                s += arr[i];
            }

            else {
                s = arr[i];
                cnt++;
            }
        }

        if (cnt + 1 <= m) {
            return true;
        }

        else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        right = 0;
        left = 0;
        min = Integer.MAX_VALUE;
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        solution();
        System.out.println(min);
    }
}