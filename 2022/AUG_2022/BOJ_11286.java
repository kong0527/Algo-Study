import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> min = new PriorityQueue<>(); // 최소힙
        PriorityQueue<Long> max = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (num == 0) {
                // max에만 값이 있는 경우
                if (min.isEmpty() && !max.isEmpty()) {
                    long maxNum = max.poll();
                    sb.append(maxNum).append("\n");
                }

                // min에만 값이 있는 경우
                else if (!min.isEmpty() && max.isEmpty()) {
                    long minNum = min.poll();
                    sb.append(minNum).append("\n");
                }

                // 둘다 빈 경우
                else if (min.isEmpty() && max.isEmpty()) {
                    sb.append("0").append("\n");
                }

                // 둘 다 값이 있는 경우
                else {
                    long maxNum = Math.abs(max.peek());
                    long minNum = Math.abs(min.peek());
                    if (maxNum > minNum) {
                        minNum = min.poll();
                        sb.append(minNum).append("\n");
                    }

                    else {
                        maxNum = max.poll();
                        sb.append(maxNum).append("\n");
                    }
                }
            }

            else if (num > 0) {
                min.add(num);
            }

            else if (num < 0) {
                max.add(num);
            }
        }
        System.out.println(sb.toString());
    }
}