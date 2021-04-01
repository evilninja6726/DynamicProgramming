package dynamicProgramming;

import java.util.Arrays;

public class LCSMemoization {
    public static void main(String[] args) {
        System.out.println(lcsRec("axyz", "baz", 4, 3));
        String s1 = "axyz";
        String s2 = "baz";
        memoization = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < memoization.length; i++)
            Arrays.fill(memoization[i], -1);
        System.out.println(lcsMemoization(s1, s2, s1.length(), s2.length()));
    }

    public static int lcsRec(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + lcsRec(s1, s2, m - 1, n - 1);
        else
            return Math.max(lcsRec(s1, s2, m - 1, n), lcsRec(s1, s2, m, n - 1));
    }

    static int memoization[][];

    public static int lcsMemoization(String s1, String s2, int m, int n) {
        if (memoization[m][n] != -1)
            return memoization[m][n];

        if (m == 0 || n == 0)
            memoization[m][n] = 0;
        else {
            if (s1.charAt(m - 1) == s2.charAt(n - 1))
                memoization[m][n] = 1 + lcsMemoization(s1, s2, m - 1, n - 1);
            else
                memoization[m][n] = Math.max(lcsMemoization(s1, s2, m - 1, n), lcsMemoization(s1, s2, m, n - 1));
        }
        return memoization[m][n];
    }
}
