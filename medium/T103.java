package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * ����β������
 * ����һ����������������ڵ�ֵ�ľ���β�������������ȴ������ң��ٴ������������һ��������Դ����ƣ������֮�佻����У�
 * �����������deque
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
				
				//���
				if(isOrder) {
					tmpList.offerLast(node.val);
				}
				else {
					tmpList.offerFirst(node.val);
				}
					
				//ѹ�����ҽڵ�
                if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right !=null) {
					q.offer(node.right);
				}
			}
			
			isOrder=!isOrder;
			ans.add(new LinkedList<Integer> (tmpList));//deque ����linkedlist������
		}
		return ans;
    }
}
