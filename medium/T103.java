package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 * 输出变量做成deque
 */
public class T103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		if (root == null) {
			return ans;
		}
		
		q.offer(root);
		boolean isOrder=true;
		while (!q.isEmpty()) {
			Deque<Integer> tmpList = new LinkedList<Integer>();
			int size= q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node=new TreeNode(0);
				node=q.poll();
				
				//输出
				if(isOrder) {
					tmpList.offerLast(node.val);
				}
				else {
					tmpList.offerFirst(node.val);
				}
					
				//压入左右节点
                if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right !=null) {
					q.offer(node.right);
				}
			}
			
			isOrder=!isOrder;
			ans.add(new LinkedList<Integer> (tmpList));//deque 加入linkedlist数组中
		}
		return ans;
    }
}
