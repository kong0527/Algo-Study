import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Time> arr = new ArrayList<>();
        int max = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            max = Math.max(max, e);
            arr.add(new Time(s, e));
        }

        int last = 0;
        Collections.sort(arr, Collections.reverseOrder());

        for (Time t : arr) {
            if (last <= t.start) {
                count++;
                last = t.end;
            }
        }

        System.out.println(count);
    }


    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // end 기준으로 비교 후 같으면 start 기준으로 비교
        @Override
        public int compareTo(Time o) {
            int endDiff = o.end - end;
            int startDiff = o.start - start;

            if (endDiff != 0) {
                return endDiff;
            }

            return startDiff;
        }
    }
}