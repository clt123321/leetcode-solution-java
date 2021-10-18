package easy;

public class T101 {
	/*
	 * 判断一棵树是否是对称的
	 * 
	 */
	 public boolean isSymmetric(TreeNode root) {
		 if(root == null) return true;
		 return compare(root.left,root.right);
	  }

	private boolean compare(TreeNode left, TreeNode right) {
		//处理空指针(终止条件)
		if(left == null && right ==null)return true;
        if(left == null || right ==null)return false;
     
        //处理下一层和当前值
        return (left.val == right.val)&&compare(left.left,right.right)&&compare(left.right, right.left);//后序
	}
	
	
	

}
