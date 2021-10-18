package medium;

public class T222 {
	/*
	 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
	 */
	 public static int countNodes(TreeNode root) {
		 if(root == null)return 0;
		 int right = countNodes(root.right);
		 int left = countNodes(root.left);
		 return left+right+1;
	 }

}
