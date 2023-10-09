import java.util.*;

class Solution {
    int mod = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m+1][n+1][2]; //0:위쪽, 1:왼쪽
        dp[1][1][0] = dp[1][1][1] = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (cityMap[i-1][j-1] == 0) {
                    dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1]) % mod;
                    dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1]) % mod;
                }
                else if (cityMap[i-1][j-1] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }
                else {
                    dp[i][j][0] = dp[i-1][j][0];
                    dp[i][j][1] = dp[i][j-1][1];
                }
            }
        }
        return dp[m][n][0];
    }
}
