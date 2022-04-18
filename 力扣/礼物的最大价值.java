package 力扣;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/1622:30
 */
public class 礼物的最大价值 {
    /**
     * 滚动数组
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n+1];
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                dp[j] = Math.max(dp[j],dp[j-1])+grid[i-1][j-1];
            }
        }

        return dp[n];
    }

    /**
     * 二维dp
     * @param grid
     * @return
     */
    public int maxValue1(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}
