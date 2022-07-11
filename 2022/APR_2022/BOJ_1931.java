import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            String st[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(st[0]);
            arr[i][1] = Integer.parseInt(st[1]);
        }

        // 회의가 끝나는 시간을 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // 끝나는 시간이 같을 경우 시작시간이 빠른 순으로 정렬
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int endTime = 0;

        for(int i = 0; i < n; i++) {
            // 종료 시간이 시작시간보다 작거나 같다면 종료시간 갱신
            if(arr[i][0] >= endTime) {
                endTime = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
