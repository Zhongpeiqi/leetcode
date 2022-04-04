package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/3010:26
 */
public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res,list,nums,0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums,int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(res, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
}
