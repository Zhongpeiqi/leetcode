package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/511:43
 */
public class 数组中重复的数据 {
    public List<Integer> findDuplicates(int[] nums) {
        int l = nums.length;
        for (int i : nums) {
            int j = (i - 1) % l;
            nums[j] += l;
        }
        List<Integer> ret = new LinkedList<Integer>();
        for (int i = 0; i < l; i++) {
            if (nums[i] > 2 * l) {
                ret.add(i + 1);

            }
        }
        return ret;
    }
}
