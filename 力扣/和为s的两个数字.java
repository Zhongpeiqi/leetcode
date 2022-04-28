package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/2715:22
 */
public class 和为s的两个数字 {
    //set
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {

            if (!set.contains(target - num)) {
                set.add(num);
            } else {
                return new int[]{num, target - num};
            }
        }

        return new int[]{};
    }

    public int[] twoSum1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int cur = nums[left] + nums[right];
            if(cur==target){
                return new int[]{nums[left], nums[right]};
            }else if(cur>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }

    //二分
    public int[] twoSum3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //1.先二分缩小范围
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] + nums[mid] > target) {
                right = mid - 1;
            } else if (nums[right] + nums[mid] < target) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if (left >= right) {
            return null;
        }
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{nums[left], nums[right]};
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            }
        }
        return null;
    }
}
