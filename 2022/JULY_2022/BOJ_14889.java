import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int answer;
    static boolean visited[];
    static int arr[][];
    static void combination(int[] index, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            // 모두 골랐으면 pick 호출
            pick(index,visited, n);
            return;
        }

        // 백트래킹으로 조합의 경우의 수 구하기
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(index, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // comb로 선택된 인덱스들과 선택되지 않은 인덱스 분리
    static void pick(int[] index, boolean[] visited, int n) {
        int sIdx = 0;
        int lIdx = 0;
        int[] start = new int[n / 2];
        int[] link = new int[n / 2];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                start[sIdx++] = index[i];
            }
            else {
                link[lIdx++] = index[i];
            }
        }
        getDiff(start, link);
    }

    // start와 link팀 점수 계산
    static void getDiff(int[] start, int[] link) {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < start.length; i++) {
            for (int j = 0; j < start.length; j++) {
                if (i == j) {
                    continue;
                }
                startSum += arr[start[i]][start[j]];
            }
        }

        for (int i = 0; i < link.length; i++) {
            for (int j = 0; j < link.length; j++) {
                if (i == j) {
                    continue;
                }
                linkSum += arr[link[i]][link[j]];
            }
        }

        answer = Math.min(answer, Math.abs(startSum - linkSum));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        int[] people = new int[n];
        answer = Integer.MAX_VALUE;
        visited = new boolean[n];
        for (int i = 0; i < people.length; i++) {
            people[i] = i;
        }

        combination(people, visited, 0, n, n / 2);

        System.out.println(answer);
    }
}

