package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2113:26
 */
public class 青蛙跳台阶问题 {
    public int numWays(int n) {
        if(n==0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
