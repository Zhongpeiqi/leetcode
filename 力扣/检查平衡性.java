package 力扣;

/**
 * @author peiqi
 * @date 2022/4/1310:58
 */
public class 检查平衡性 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //高度差小于1
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }
}
