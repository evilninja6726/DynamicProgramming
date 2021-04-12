package dynamicProgramming;

public class CountChange {
    public static void main(String[] args) {
        System.out.println(countChange(new int[]{2, 3, 5, 6}, 4, 10));
        System.out.println(countChangeDP(new int[]{2, 3, 5, 6}, 4, 10));
    }

    public static int countChange(int[] arr, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int res = countChange(arr, n - 1, sum);
        if (sum >= arr[n - 1]) {
            res += countChange(arr, n, sum - arr[n - 1]);
        }
        return res;
    }

    public static int countChangeDP(int[] arr, int n, int sum) {
        int[][] table = new int[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            table[0][i] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i][j - 1];
                if (arr[j - 1] <= i) {
                    table[i][j] += table[i - arr[j - 1]][j];
                }
            }
        }
        return table[sum][n];
    }
}
