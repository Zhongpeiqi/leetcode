package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/2920:29
 */
public class 全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean [] visit = new boolean[nums.length];
        //排序方便去重
        Arrays.sort(nums);
        backtrack(res,list,nums,visit);
        return res;
    }

    private void backtrack(List<List<Integer>> res, ArrayList<Integer> list, int[] nums,boolean [] visit) {
        //结束条件
        if(list.size()== nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //访问过
            if(visit[i]){
                continue;
            }
            // 如果数组相连元素相等，没有先访问后面的元素，就不会存在重复
            if (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]){
                continue;
            }
            list.add(nums[i]);
            visit[i] = true;
            backtrack(res, list, nums, visit);
            // 回溯后，重新标记为未访问，删掉最后一个元素
            visit[i] = false;
            list.remove(list.size()-1);
        }
    }
}
