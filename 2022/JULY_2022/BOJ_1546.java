import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static double solution(int[] arr) {
        double avg = 0;
        Arrays.sort(arr);
        int max = arr[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            avg += (double) arr[i] / max * 100;
        }

        return avg / arr.length;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println(solution(arr));
    }
}