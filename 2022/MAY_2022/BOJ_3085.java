import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static int solution(char[][] arr, int n) {
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    break;
                }

                // 검사하려는 곳이 맨 오른쪽 열이면 아래만 검사
                if (j == n - 1) {
                    if (arr[i][j] != arr[i + 1][j]) {
                        swap(arr, i, j, "d");
                        max = Math.max(max, check(arr));
                        swap(arr, i, j, "d");
                    }
                }

                // 검사하려는 곳이 맨 아래쪽 행이면 오른쪽만 검사
                else if (i == n - 1) {
                    if (arr[i][j] != arr[i][j + 1]) {
                        swap(arr, i, j, "r");
                        max = Math.max(max, check(arr));
                        swap(arr, i, j, "r");
                    }
                }

                // 그 외의 경우에는 오른쪽, 아래쪽 다 검사
                else {
                    if (arr[i][j] != arr[i][j + 1]) {
                        swap(arr, i, j, "r");
                        max = Math.max(max, check(arr));
                        swap(arr, i, j, "r");
                    }

                    if (arr[i][j] != arr[i + 1][j]) {
                        swap(arr, i, j, "d");
                        max = Math.max(max, check(arr));
                        swap(arr, i, j, "d");
                    }

                }
            }
        }

        return max;
    }

    public static void swap(char[][] arr, int x, int y, String direction) {
        if (direction.equals("r")) {
            char tmp = arr[x][y + 1];
            arr[x][y + 1] = arr[x][y];
            arr[x][y] = tmp;
        }

        else if (direction.equals("d")) {
            char tmp = arr[x + 1][y];
            arr[x + 1][y] = arr[x][y];
            arr[x][y] = tmp;
        }
    }

    public static int check(char[][] arr) {
        int max = 1;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    count++;
                }
                else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    count++;
                }
                else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }


        return max;
    }

    public static boolean isAllSame(char[][] arr) {
        boolean flag = true;
        char ch = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (ch != arr[i][j]) {
                    return false;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        if (isAllSame(arr)) {
            System.out.println(0);
        }
        else {
            System.out.println(solution(arr, n));
        }
    }
}