import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split("-");
        int answer = 0;

        for (int i = 0; i < st.length; i++) {
            String tmp = st[i];
            int sum = 0;
            String num = "";
            for (int j = 0; j < tmp.length(); j++) {
                char ch = tmp.charAt(j);
                if (Character.isDigit(ch)) {
                    num += ch;
                }

                // + 이면
                else {
                    sum += Integer.parseInt(num);
                    num = "";
                }
            }

            sum += Integer.parseInt(num);

            if (i == 0) {
                answer = sum;
            }

            else {
                answer -= sum;
            }
        }

        System.out.println(answer);
    }
}