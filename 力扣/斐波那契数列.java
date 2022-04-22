package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2113:18
 */
public class 斐波那契数列 {
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
