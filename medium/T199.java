package medium;
/*
 * 二叉树右视图（中等）
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans= new ArrayList<Integer>();
		if(root ==null)return ans;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int tem=0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if(i == size-1)tem=node.val;
				if(node.left != null) {
					q.offer(node.left);
				}
				if(node.right != null) {
					q.offer(node.right);
				}
				
			}
			ans.add(tem);
		}
		return ans;
	

    }

}
