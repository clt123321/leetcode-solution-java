package easy;
/*
 * 给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */

public class T104 {
	
	public int maxDepth(TreeNode root) {
		if(root == null)return 0;
		int leftDepth = maxDepth(root.left);
		int rightDepth =maxDepth(root.right);
		return 1+Math.max(leftDepth, rightDepth);		
	}
	

}
