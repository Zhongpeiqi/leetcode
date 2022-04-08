package 力扣;

/**
 * @author peiqi
 * @date 2022/4/415:06
 */

import java.util.*;

/**
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class 从上到下打印二叉树II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }

        return res;
    }
}
