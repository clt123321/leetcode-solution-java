package easy;

public class T226 {
	/*
	 *  ��ת������
	 *  ǰ��ͺ��򶼿��ԣ�ֻ�������С�
	 */
	public static TreeNode invertTree(TreeNode root) {
        if(root ==null)return root;
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
	
	public static void swap(TreeNode root) {
		TreeNode tepNode;
		tepNode=root.left;
		root.left= root.right;
		root.right=tepNode;
	}
}
