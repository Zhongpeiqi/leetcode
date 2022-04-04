package 力扣;

/**
 * @author peiqi
 * @date 2022/3/2314:47
 */
public class 求根节点到叶节点数字之和 {

    public static int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private static int dfs(TreeNode root,int i) {
        if(root==null){
            return 0;
        }
        int temp = i*10+root.val;
        if(root.left==null&&root.right==null){
            return temp;
        }
        return dfs(root.left,temp)+dfs(root.right,temp);
    }
}
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

