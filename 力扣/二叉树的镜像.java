package 力扣;

/**
 * @author peiqi
 * @date 2022/4/2013:47
 */
public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

}
