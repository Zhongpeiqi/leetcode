package 力扣;

import java.util.Scanner;

/**
 * @author peiqi
 * @date 2022/3/2511:17
 */
public class 古生物血缘关系判断 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.next().split(",");
        System.out.println(minDistance(arr[0], arr[1]));
    }

    /**
     *
     * @param word1 需要修改的字符串
     * @param word2 参考字符串
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int dp[][] = new int[len1+1][len2+1];
        //初始化
        for(int i = 1;i<=len1;i++){
            dp[i][0] = dp[i-1][0]+1;
        }

        for(int i=1;i<=len2;i++){
            dp[0][i] = dp[0][i-1]+1;
        }

        for(int i = 1;i<=len1;i++){
            for(int j = 1;j<len2+1;j++){
                //取增删改步骤最小的一步
                dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1])) + 1;
                //相同不需要进行额外的操作
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
