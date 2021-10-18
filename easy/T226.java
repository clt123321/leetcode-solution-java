package easy;

public class T226 {
	/*
	 *  翻转二叉树
	 *  前序和后序都可以，只有中序不行。
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
