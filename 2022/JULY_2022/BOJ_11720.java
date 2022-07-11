import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long solution(String s) {
        long sum = 0;

        for (char ch : s.toCharArray()) {
            sum += ch - '0';
        }

        return sum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(solution(s));
    }
}