package 力扣;

/**
 * @author peiqi
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/2310:19
 */
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int getDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(getDepth(root.left),getDepth(root.right))+1;
    }
}
