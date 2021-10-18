package medium;
/*
 * 二叉树层序遍历2（中等）
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T107 {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 List<List<Integer>> a = new ArrayList<List<Integer>>();
		 if(root == null)return a;
		 
		 Queue<TreeNode> q = new LinkedList<TreeNode>();
		 q.offer(root);
		 while(!q.isEmpty()) 
		 { 
			 
			 List<Integer> tem = new ArrayList<Integer>();
			 int size = q.size();
			 for (int i = 0; i < size; i++) {
				 TreeNode node= q.poll();
				 tem.add(node.val);
				 if(node.left != null) {
					 q.offer(node.left);
				 }
				 if(node.right != null) {
					 q.offer(node.right);
				 }
			}
			a.add(0,tem);
		 }
		 return a;
		 
		 
		 
		 

	 }

}
