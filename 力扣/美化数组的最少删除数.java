package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/2710:44
 */
public class 美化数组的最少删除数 {
//    public int minDeletion(int[] nums) {
//        int len = nums.length;
//        int res = 0;
//        for (int i = 1; i < len; i++) {
//            if((i-res)%2==0||nums[i]!=nums[i-1]){
//                continue;
//            }
//            res++;
//        }
//        return (len - res) % 2 == 0 ? res : res + 1;
//    }

    public int minDeletion(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 1; i < n; i++) {
            //栈的大小为偶数时，此时可以直接将数据压入栈
            if(stack.size()%2==0){
                stack.push(nums[i]);
            }else{
                //为奇数时需要判断栈顶元素是否相同，相同则不能添加
                int val = stack.peek();
                if(nums[i]==val){
                    continue;
                }
            }
        }
        if (stack.size() % 2 == 0) {
            return n - stack.size();
        }
        //当栈的大小为奇数时，需要减去栈顶元素，所以删除的次数要加1
        return n - stack.size() + 1;

    }
}
