package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/3/299:14
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        //结果集合
        List<List<Integer>> res = new ArrayList<>();
        //每一种排序的可能结果
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size()== nums.length){
            //拷贝一份
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if(!list.contains(num)){
                list.add(num);
                backtrack(res, list, nums);
                //删除新增的
                list.remove(list.size()-1);
            }
        }
    }
}
