package medium;

public class T222 {
	/*
	 * ����һ�� ��ȫ������ �ĸ��ڵ� root ����������Ľڵ������
	 */
	 public static int countNodes(TreeNode root) {
		 if(root == null)return 0;
		 int right = countNodes(root.right);
		 int left = countNodes(root.left);
		 return left+right+1;
	 }

}
