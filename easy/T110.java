package easy;

public class T110 {
	/*
	 * �ж�һ�����Ƿ���ƽ�������
	 * ���ҽڵ�߶Ȳ�ֵ������1
	 */
	
	//�����������߶ȵĴ��룬����ƽ���򷵻�-1;�ø��ڵ�ĸ߶�ֵ�ж�
	public boolean isBalanced(TreeNode root) {
		return getDepth(root)==-1?false:true;
    }
	public int getDepth(TreeNode node) {
		if (node== null) {
			return 0;
		}
		int leftLegth = getDepth(node.left);
		if(leftLegth == -1) return -1;//˵���Ѿ����Ƕ�����
		int rightLegth = getDepth(node.right);
		if (rightLegth == -1) return -1;
		
		return Math.abs(leftLegth-rightLegth)>1?-1:Math.max(leftLegth, rightLegth)+1;
	}

}
