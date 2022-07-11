package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int solution(int n, int[] one, int[] two) {
        int sum = 0;
        int idx1 = one.length - 1;
        int idx2 = two.length - 1;
        Arrays.sort(one);
        Arrays.sort(two);
        // n이 홀수인 경우 2 x 1 사각형 하나를 무조건 써야 하므로
        // 제일 최댓값으로 하나 넣어주고 n을 하나 줄여준다.
        if (n % 2 == 1) {
            sum += one[idx1--];
            n--;
        }

        // 그러면 우리는 이제 2 x 2 사각형만 n / 2개 만들면 된다.
        for (int i = 2; i <= n; i += 2) {
            // 둘 다 인덱스 범위 안이라서 정상적으로 비교가 가능하면
            if (idx1 >= 1 && idx2 >= 0) {
                // 2 x 1을 쓸 것인지 2 x 2를 쓸 것인지 비교
                if (two[idx2] > one[idx1] + one[idx1 - 1]) {
                    sum += two[idx2--];
                }

                else {
                    sum += one[idx1] + one[idx1 - 1];
                    idx1 -= 2;
                }
            }

            // 2 x 2가 하나도 남지 않았으면 2 x 1만 사용해야 한다.
            else if (idx1 >= 1 && idx2 < 0) {
                sum += one[idx1] + one[idx1 - 1];
                idx1 -= 2;
            }

            // 2 x 1이 한개 혹은 0개만 남았을 경우 2 x 2만 사용해야 한다.
            else if (idx1 < 1 && idx2 >= 0) {
                sum += two[idx2--];
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int a = Integer.parseInt(st[1]);
        int b = Integer.parseInt(st[2]);
        int[] one = new int[a];
        int[] two = new int[b];

        st = br.readLine().split(" ");
        for (int i = 0; i < one.length; i++) {
            one[i] = Integer.parseInt(st[i]);
        }

        st = br.readLine().split(" ");
        for (int i = 0; i < two.length; i++) {
            two[i] = Integer.parseInt(st[i]);
        }

        System.out.println(solution(n, one, two));
    }
}