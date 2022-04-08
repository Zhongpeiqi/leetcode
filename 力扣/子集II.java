package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/3010:48
 */
public class 子集II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //方便去重
        Arrays.sort(nums);
        backtrack(0,list,res,nums);
        return res;
    }

    private void backtrack(int i, List<Integer> list, List<List<Integer>> res, int[] nums) {
        //不选择
        res.add(new ArrayList<>(list));
        for (int j = i; j < nums.length ; j++) {
            //当前元素与上一个元素相等则跳过
            if(j>i&&nums[j]==nums[j-1]){
                continue;
            }
            list.add(nums[j]);
            backtrack(j+1,list,res,nums);
            list.remove(list.size()-1);
        }
    }
}
