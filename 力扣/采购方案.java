package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/3011:11
 */
public class 采购方案 {
    public int purchasePlans(int[] nums, int target) {
        /**
         * 排序后二分
         * 采购大于目标值则右右指针左移
         * 否则count+=right-left;
         * 因为 如果1+3<6,则1+2<6
         * 左指针右移
         */
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int count = 0;

        while (left<right){
            if(nums[left]+nums[right]>target){
                right--;
            }else{
                count+=right-left;
                left++;
                count %= 1000000007;
            }
        }
        return count%1000000007;
    }
}
