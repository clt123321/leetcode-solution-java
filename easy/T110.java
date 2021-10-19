package easy;

public class T110 {
	/*
	 * 判断一颗树是否是平衡二叉树
	 * 左右节点高度差值不超过1
	 */
	
	//改造了求树高度的代码，若不平衡则返回-1;用根节点的高度值判断
	public boolean isBalanced(TreeNode root) {
		return getDepth(root)==-1?false:true;
    }
	public int getDepth(TreeNode node) {
		if (node== null) {
			return 0;
		}
		int leftLegth = getDepth(node.left);
		if(leftLegth == -1) return -1;//说明已经不是二叉树
		int rightLegth = getDepth(node.right);
		if (rightLegth == -1) return -1;
		
		return Math.abs(leftLegth-rightLegth)>1?-1:Math.max(leftLegth, rightLegth)+1;
	}

}
