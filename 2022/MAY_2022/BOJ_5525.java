package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int solution(int n, String parent) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("I");

        for (int i = 0; i < n; i++) {
            sb.append("OI");
        }

        int[] pi = makePi(sb.toString());
        int j = 0;

        for (int i = 0; i < parent.length(); i++) {
            while (j > 0 && parent.charAt(i) != sb.charAt(j)) {
                j = pi[j - 1];
            }

            if (parent.charAt(i) == sb.charAt(j)) {
                if (j == sb.length() - 1) {
                    count++;
                    j = pi[j];
                }
                else {
                    j++;
                }
            }
        }
        return count;
    }

    public static int[] makePi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    // 전형적인 방법 - 시간초과
    public static int solution2(int n, String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("I");

        for (int i = 0; i < n; i++) {
            sb.append("OI");
        }

        int length = sb.length();

        for (int i = 0; i <= s.length() - length; i++) {
            String tmp = s.substring(i, i + length);
            if (tmp.equals(sb.toString())) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        System.out.println(solution(n, s));
    }
}

