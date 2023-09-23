import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <pre>
 *
 * description edit here
 *
 * @since       : 2023-09-21
 * @author      : kimhyok0
 * @version     : 1.0
 * @see         :
 *
 *
 *
 * </pre>
 */
public class BOJ_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        int[] result = getNumber(arr);
        for (int n : result) {
            System.out.println(n);
        }
    }

    public static int[] getNumber(List<Integer> arr) {
        int[] result = new int[4];
        int size = arr.size();

        // arr 정렬
        Collections.sort(arr);
        long sum = 0;

        // 중앙값
        result[1] = arr.get(size / 2);

        // 최빈값
        int prev = arr.get(0);
        int count = 0;
        int maxCnt = 0;
        int updateCnt = 0;
        int most = arr.get(0);
        for (int i = 0; i < size; i++) {
            int num = arr.get(i);
            sum += num;
            if (prev == num) {
                count++;
            }
            if (prev != num || i == size - 1) {

                if (count > maxCnt) {
                    maxCnt = count;
                    updateCnt = 0;
                    most = prev;
                } else if (count == maxCnt) {
                    if (updateCnt == 0) {
                        most = prev;
                    }
                    updateCnt++;
                }
                prev = num;
                count = 1;
            }
        }
        result[2] = most;

        // 산술평균
        result[0] = Math.round((float) sum / size);

        // 범위
        result[3] = arr.get(size - 1) - arr.get(0);

        return result;
    }
}
