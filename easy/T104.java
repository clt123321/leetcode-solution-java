package easy;
/*
 * ����һ�����������ҳ��������ȡ�
�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����
 */

public class T104 {
	
	public int maxDepth(TreeNode root) {
		if(root == null)return 0;
		int leftDepth = maxDepth(root.left);
		int rightDepth =maxDepth(root.right);
		return 1+Math.max(leftDepth, rightDepth);		
	}
	

}
