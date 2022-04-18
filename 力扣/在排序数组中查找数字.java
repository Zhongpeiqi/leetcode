package 力扣;

/**
 * @author peiqi
 * @date 2022/4/179:53
 */

import java.util.*;

/**
 * 统计一个数字在排序数组中出现的次数
 */
public class 在排序数组中查找数字 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int count = 0;
        while (left<right){
            int mid = (left+right)>>1;
            if(nums[mid]>=target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        while(left<nums.length&&nums[left++]==target){
            count++;
        }
        return count;
    }
}
