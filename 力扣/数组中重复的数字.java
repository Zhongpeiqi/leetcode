package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/178:45
 */
public class 数组中重复的数字 {
    /**
     * 使用set实现，时间优先，时间O(n)，空间O(n),不修改原数据
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 利用索引与数字的关系，时间O(n)，空间O(1)，修改了原数据
     * @param nums
     * @return
     */
    public int findRepeatNumber1(int[] nums) {
        if(nums==null || nums.length==0) {
            return -1;
        }
        for(int i = 0 ; i < nums.length;i++){
            //如果该数字没有不和他的索引相等
            while(nums[i]!=i){
                //重复返回
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                //不重复交换
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}
