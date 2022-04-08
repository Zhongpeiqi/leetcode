package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/2920:51
 */
public class 组合总和II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null){
            return res;
        }
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int index) {
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
        }

        for (int start = index; start < candidates.length; start++) {
            if(candidates[start]<=target){
                // 如果数组相连元素相等，没有先访问后面的元素，就不会存在重复
                if (start > index && candidates[start] == candidates[start - 1]){
                    continue;
                }
                path.add(candidates[start]);
                backtrack(candidates, target-candidates[start], start+1);
                path.remove(path.size()-1);
            }
        }
    }
}
