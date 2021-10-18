package medium;
/*
 * ����������ͼ���еȣ�
 * ����һ���������� ���ڵ� root�������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
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
