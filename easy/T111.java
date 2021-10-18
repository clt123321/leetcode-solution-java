package easy;

public class T111 {
	/*
	 * 一颗树的最小深度
	 */
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		 int leftDepth = minDepth(root.left); // 左
		 int rightDepth = minDepth(root.right); // 右
		 
		 if(root.right!=null && root.left ==null) {
			 return rightDepth+1;
		 }
		 if(root.left !=null && root.right ==null) {
			 return leftDepth+1;
		 }
		 
		 return Math.min(leftDepth, rightDepth)+1;

    }

}
