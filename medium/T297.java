package medium;
import java.awt.HeadlessException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

/*
 * 二叉树序列化和反序列化（困难）
 * 先序遍历的模式
 */

public class T297 {
	 private class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 
	 
	 public static void main(String[] args) {
		System.out.println();
	}
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root ==null) return "!_";
        String res = root.val+"_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] value= data.split("_");
    	Queue<String> queue= new LinkedList<String> ();
    	for (int i = 0; i < value.length; i++) {
			queue.add(value[i]);
		}
    	return reconPreOrder(queue);
    }

	private TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if(value.contentEquals("!"))return null;
		TreeNode head= new TreeNode(Integer.valueOf(value));
		head.left= reconPreOrder(queue);
		head.right= reconPreOrder(queue);
		return head;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));


