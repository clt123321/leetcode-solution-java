package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class T513 {
	/*
	 * 给定⼀个⼆叉树，在树的最后⼀⾏找到最左边的值。(中等）
	 * 
	 */
	public int findBottomLeftValue(TreeNode root) {
		List<List<Integer>> ans =new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		if (root.left ==null && root.right ==null) {
			return root.val;
		}
		
		q.offer(root);// 1队列中放入root
		TreeNode a = new TreeNode(0);
		while(!q.isEmpty()) { //2队列非空时
			int currentSize=q.size();//2.1取当前的size q的size是一直在变化的
			for (int i = 0; i < currentSize; i++) {
				a = q.poll();//2.2弹出队首
				
				
				if(a.right != null) {
					q.offer(a.right);
				}
				if(a.left!= null) {
					q.offer(a.left);//2.3队列中压入左右节点
				}
			}
		}
		return a.val;
    }
	

}
