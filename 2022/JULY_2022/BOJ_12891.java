
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int correct;
    static int[] arr;
    static int[] chk;

    public static int solution(char[] dna, int s, int p) {
        int count = 0;

        for (int i = 0; i < p; i++) {
            add(dna[i]);
        }

        if (correct == 4) {
            count++;
        }

        for (int i = p; i < s; i++) {
            add(dna[i]);
            remove(dna[i - p]);
            if (correct == 4) {
                count++;
            }
        }

        return count;
    }

    public static void add(char ch) {
        if (ch == 'A') {
            chk[0]++;
            if (arr[0] == chk[0]) {
                correct++;
            }
        }

        else if (ch == 'C') {
            chk[1]++;
            if (arr[1] == chk[1]) {
                correct++;
            }
        }

        else if (ch == 'G') {
            chk[2]++;
            if (arr[2] == chk[2]) {
                correct++;
            }
        }

        else {
            chk[3]++;
            if (arr[3] == chk[3]) {
                correct++;
            }
        }
    }

    public static void remove(char ch) {
        if (ch == 'A') {
            if (arr[0] == chk[0]) {
                correct--;
            }
            chk[0]--;
        }

        else if (ch == 'C') {
            if (arr[1] == chk[1]) {
                correct--;
            }
            chk[1]--;
        }

        else if (ch == 'G') {
            if (arr[2] == chk[2]) {
                correct--;
            }
            chk[2]--;
        }

        else {
            if (arr[3] == chk[3]) {
                correct--;
            }
            chk[3]--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int s = Integer.parseInt(st[0]);
        int p = Integer.parseInt(st[1]);
        correct = 0;
        chk = new int[4];
        char[] dna = br.readLine().toCharArray();
        st = br.readLine().split(" ");
        arr = new int[4];

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st[i]);
            if (arr[i] == 0) {
                correct++;
            }
        }
        System.out.println(solution(dna, s, p));
    }

}