import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long solution(int[] arr, int[] supervisor) {
        long answer = arr.length;

        for (int i = 0; i < arr.length; i++) {
            arr[i] -= supervisor[0];
            if (arr[i] > 0) {
                answer += Math.ceil((float) arr[i] / supervisor[1]);
            }
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] st = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        int[] supervisor = new int[2];
        st = br.readLine().split(" ");
        supervisor[0] = Integer.parseInt(st[0]);
        supervisor[1] = Integer.parseInt(st[1]);

        System.out.println(solution(arr, supervisor));
    }
}

