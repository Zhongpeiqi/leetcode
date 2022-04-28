package 力扣;

/**
 * @author peiqi
 * @date 2022/4/240:19
 */
public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        //字符串长度为i的翻译方法
        int[] dp = new int[str.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<str.length();i++){
            String tempStr = str.substring(i-2,i);
            System.out.println(tempStr);
            if (tempStr.compareTo("10") >= 0 && tempStr.compareTo("25") <= 0) {
                dp[i] = dp[i-1]+dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
    public int translateNum1(int num) {
        if (num < 10) {
            return 1;
        }
        int pre = num % 100;
        if (pre >= 10 && pre <= 25) {
            return translateNum(num/10) + translateNum(num/100);
        } else {
            return translateNum(num/10);
        }
    }
}
