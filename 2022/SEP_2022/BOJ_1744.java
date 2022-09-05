import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                max.add(num);
            }

            else {
                min.add(num);
            }
        }

        while (!min.isEmpty()) {
            if (min.size() == 1) {
                answer += min.poll();
            }

            else {
                int num1 = min.poll();
                int num2 = min.poll();
                answer += num1 * num2;
            }
        }

        while (!max.isEmpty()) {
            if (max.size() == 1) {
                answer += max.poll();
            }

            else {
                int num1 = max.poll();
                int num2 = max.poll();
                if (num1 * num2 >= num1 + num2) {
                    answer += num1 * num2;
                }

                else {
                    answer += num1 + num2;
                }
            }
        }

        System.out.println(answer);
    }
}