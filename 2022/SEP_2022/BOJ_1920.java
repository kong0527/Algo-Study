import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;

    public static int solution(int n) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > n) {
                end = mid - 1;
            }

            else if (arr[mid] == n) {
                return 1;
            }

            else {
                start = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String[] st = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            sb.append(solution(Integer.parseInt(st[i]))).append("\n");
        }

        System.out.println(sb);
    }
}