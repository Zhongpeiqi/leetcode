package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1513:07
 */
public class 一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1的最大子集
        int[][] dp = new int[m+1][n+1];
        int oneNum,zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char c : str.toCharArray()) {
                if(c=='0'){
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }

            for (int i = m; i>=zeroNum; i--) {
                for (int j = n; j>=oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
