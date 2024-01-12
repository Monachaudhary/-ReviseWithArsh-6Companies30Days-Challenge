class Solution {
    public int maxProduct(String s) {
        int n = s.length();
        int maxProduct = 0;

        for (int i = 1; i < (1 << n); i++) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    s1.append(s.charAt(j));
                } else {
                    s2.append(s.charAt(j));
                }
            }

            int len1 = longestPalindromic(s1.toString());
            int len2 = longestPalindromic(s2.toString());

            maxProduct = Math.max(maxProduct, len1 * len2);
        }

        return maxProduct;
    }

    private int longestPalindromic(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return LCS(s, sb.toString(), n, n);
    }

    private int LCS(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
