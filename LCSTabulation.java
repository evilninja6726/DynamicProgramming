package dynamicProgramming;

public class LCSTabulation {
    public static void main(String[] args) {
        System.out.println(lcsTabulation("axyz", "baz"));
    }

    public static int lcsTabulation(String s1, String s2) {
        int table[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            table[i][0] = 0;
        }
        for (int i = 0; i < s2.length(); i++) {
            table[0][i] = 0;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                }
            }
        }
        return table[s1.length()][s2.length()];
    }
}
