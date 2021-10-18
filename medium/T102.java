package medium;
/*
 * 二叉树层序遍历
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.event.TreeExpansionEvent;
import javax.xml.soap.Node;



public class T102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans =new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		 //java 中队列的初始化  offer=push  poll= pop
		
		while( root == null) {
			return ans;
		}
		
		q.offer(root);// 1队列中放入root
		while(!q.isEmpty()) { //2队列非空时
			List<Integer> curLevel =new ArrayList<Integer>();
			int currentSize=q.size();//2.1取当前的size q的size是一直在变化的
			for (int i = 0; i < currentSize; i++) {
				TreeNode a= q.poll();//2.2弹出队首
				curLevel.add(a.val);//打印弹出的节点
				if(a.left!= null) {
					q.offer(a.left);//2.3队列中压入左右节点
				}
				if(a.right != null) {
					q.offer(a.right);
				}
			}
			ans.add(curLevel);
		}
		return ans;
    }

}
