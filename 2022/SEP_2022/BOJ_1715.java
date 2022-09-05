import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;

        while (pq.size() != 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            answer += num1 + num2;
            pq.add(num1 + num2);
        }

        System.out.println(answer);
    }
}