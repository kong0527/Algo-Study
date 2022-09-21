class Solution {
    int max;
    int hp;
    int[][] dg;

    public int solution(int k, int[][] dungeons) {
        max = 0;
        hp = k;
        dg = dungeons;
        int length = dungeons.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }

        permutation(arr, 0, length, length);

        return max;
    }

    public void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            adventure(arr);
            return ;
        }

        for(int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }

    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void adventure(int[] arr) {
        int count = 0;
        int k = hp;

        for (int i = 0; i < arr.length; i++) {
            int need = dg[arr[i]][0];
            int energy = dg[arr[i]][1];

            if (need <= k) {
                count++;
                k -= energy;
            }

            else {
                break;
            }
        }

        max = Math.max(max, count);
    }
}