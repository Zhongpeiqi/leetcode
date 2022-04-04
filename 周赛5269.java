package 力扣;

import java.util.List;

/**
 * @author peiqi
 * @date 2022/3/2715:34
 */
public class 周赛5269 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        //dp[i][j]表示前i个数组中取j个最大值
        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 0;
        //遍历栈
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int sum = 0;
                for (int kk = 0; kk <= piles.get(i-1).size()&&kk<=j; kk++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - kk] + sum);
                    if (kk < piles.get(i - 1).size()) {
                        sum += piles.get(i - 1).get(kk);
                    }

                }
            }
        }
        return dp[n][k];
    }
}
