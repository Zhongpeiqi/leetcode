package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/2919:47
 */
public class 组合总和 {
    /**
     * 记录答案
     */
    List<List<Integer>> res = new ArrayList<>();
    /**
     * 记录路径
     */
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null){
            return res;
        }
        backtrack(0,candidates,target);
        return res;
    }

    private void backtrack(int i,int[] candidates, int target) {
        if(target<0){
            return;
        }
        //加入结果集
        if(target==0){
            res.add(new ArrayList<>(list));
        }
        for (int j = i;j<candidates.length;j++) {
            list.add(candidates[j]);
            backtrack(j,candidates,target-candidates[j]);
            //回溯
            list.remove(list.size()-1);

        }
    }
}
