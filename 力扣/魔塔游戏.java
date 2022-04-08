package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/3110:04
 */
public class 魔塔游戏 {
    public int magicTower(int[] nums) {
        int sum = 1;
        for (int num : nums) {
            sum+=num;
        }
        if(sum<1){
            return -1;
        }

        long blood = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                pq.offer(nums[i]);
                //扣完要死了把前面扣的最多的血移到最后面去
                if(blood+nums[i]<=0){
                    last++;
                    //加回之前扣的血
                    blood -= pq.poll();
                }
            }
            blood+=nums[i];
        }
        return last;
    }
}
