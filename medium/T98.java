package medium;

public class T98 {
	/*
	 * ����һ���������ĸ��ڵ� root ���ж����Ƿ���һ����Ч�Ķ�����������
	��Ч �����������������£�
	�ڵ��������ֻ���� С�� ��ǰ�ڵ������
	�ڵ��������ֻ���� ���� ��ǰ�ڵ������
	�������������������������Ҳ�Ƕ�����������
	
	�������
	 */
	long pre =Long.MIN_VALUE;
	 public boolean isValidBST(TreeNode root) {
		 if(root == null)return true;
		 if (!isValidBST(root.left)) {
			return false;
		}
		 if (root.val <=pre) {
			return false;
		}
		 pre=root.val;

		return isValidBST(root.right);

	 }

}
