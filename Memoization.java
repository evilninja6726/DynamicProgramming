package dynamicProgramming;

import java.util.Arrays;

public class Memoization {
    public static void main(String[] args) {
        System.out.println(fib(40));
        int n = 40;
        memoization = new int[n + 1];
        Arrays.fill(memoization, -1);
        System.out.println(fibMemoization(n));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    static int[] memoization;

    public static int fibMemoization(int n) {
        if (memoization[n] == -1) {
            int res = 0;
            if (n == 0 || n == 1)
                res = n;
            else
                res = fibMemoization(n - 1) + fibMemoization(n - 2);
            memoization[n] = res;
        }
        return memoization[n];
    }
}
