package 力扣;/**  
    * @Title: 
    * @Package 
    * @Description: 
    * @author peiqi
    * @date 2022/4/2222:58
    */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            if(sum>0){
                sum +=nums[i];
            }else{
                sum = nums[i];
            }

            max = Math.max(max,sum);
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
