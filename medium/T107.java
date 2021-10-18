package medium;
/*
 * �������������2���еȣ�
 * ����һ����������������ڵ�ֵ�Ե����ϵĲ�������� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
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
