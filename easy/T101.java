package easy;

public class T101 {
	/*
	 * �ж�һ�����Ƿ��ǶԳƵ�
	 * 
	 */
	 public boolean isSymmetric(TreeNode root) {
		 if(root == null) return true;
		 return compare(root.left,root.right);
	  }

	private boolean compare(TreeNode left, TreeNode right) {
		//�����ָ��(��ֹ����)
		if(left == null && right ==null)return true;
        if(left == null || right ==null)return false;
     
        //������һ��͵�ǰֵ
        return (left.val == right.val)&&compare(left.left,right.right)&&compare(left.right, right.left);//����
	}
	
	
	

}
