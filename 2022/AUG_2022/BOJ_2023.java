import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    static int[] prime = {2, 3, 5, 7};
    static int N;
    static ArrayList<Integer> answer;

    public static void solution(int depth, int num) {
        if (depth == N) {
            answer.add(num);
            return ;
        }

        for (int i = 0; i <= 9; i++) {
            int tmp = num * 10 + i;
            if (isPrime(tmp)) {
                solution(depth + 1, tmp);
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();

        // 첫 번째 자리를 무조건 2, 3, 5, 7 중 하나로 시작해야 한 다는 것을 기억하자.
        for (int i = 0; i < prime.length; i++) {
            solution(1, prime[i]);
        }

        Collections.sort(answer);

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}