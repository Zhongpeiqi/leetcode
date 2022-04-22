package 力扣;

import java.util.*;

/**
 * @author peiqi
 * @date 2022/4/2014:24
 */
public class 二叉树染色 {
    TreeSet<Integer> set;
    public int getNumber(TreeNode root, int[][] ops) {
        if(root==null){
            return 0;
        }
        set = new TreeSet<>();
        build(root);
        int res = 0;
        for(int i = ops.length-1;i>=0;i--){
            while (true){
                //找到第一个大于x的节点
                Integer higher = set.higher(ops[i][1] - 1);
                if(higher==null||higher>ops[i][2]){
                    break;
                }
                //删除操作过的节点
                set.remove(higher);
                if(ops[i][0]==1){
                    res++;
                }
            }
        }
        return res;
    }
    private void build(TreeNode root){
        if(root == null) {
            return;
        }
        build(root.left);
        set.add(root.val);
        build(root.right);
    }
}
