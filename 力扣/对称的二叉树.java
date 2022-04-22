package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2013:56
 */
public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val==right.val&&dfs(left.left,right.right)&&dfs(left.right,right.left);
    }

}
