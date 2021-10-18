package medium;
/*
 * 将搜索二叉树转化为累加树
 */

public class T538 {
	//solution 1  反序中序遍历 累加之前的结果  空间复杂度O(logN)~O(N)
	int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            sum +=root.val;
            root.val =sum;
            convertBST(root.left);
        }
        return root;//递归基
    }
    
    //solution 2 反序中序遍历  Morris遍历法 空间复杂度O(1)
    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }

}
