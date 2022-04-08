package 力扣;

/**
 * @author peiqi
 * @date 2022/4/414:52
 */

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印
 */
public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        //存储答案
        List<Integer> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            //左右子树不为空则加入队列中
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
//        int[] res = new int[ans.size()];
//        for(int i = 0;i<ans.size();i++){
//            res[i] = ans.get(i);
//        }
//        return res;
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
