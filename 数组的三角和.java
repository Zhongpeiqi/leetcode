package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/223:04
 */
public class 数组的三角和 {
//    public static int triangularSum(int[] nums) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        return dfs(list);
//    }
//
//    private static int dfs(ArrayList<Integer> list) {
//        if(list.size()==1){
//            return list.get(0);
//        }
//        ArrayList<Integer> newList = new ArrayList<>();
//        for (int i = 0; i < list.size()-1; i++) {
//            newList.add((list.get(i)+ list.get(i+1))%10);
//        }
//
//        return dfs(newList);
//    }

//    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5};
//        System.out.println(triangularSum(nums));
//    }

    public int triangularSum(int[] nums) {
        int len = nums.length;
        for(int n = len;n>1;n--){
            for(int i = 0;i<n-1;i++){
                nums[i] = (nums[i]+nums[i+1])%10;
            }
        }
        return nums[0];
    }
}
