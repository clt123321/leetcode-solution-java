package medium;
/*
 * �������������
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
		 //java �ж��еĳ�ʼ��  offer=push  poll= pop
		
		while( root == null) {
			return ans;
		}
		
		q.offer(root);// 1�����з���root
		while(!q.isEmpty()) { //2���зǿ�ʱ
			List<Integer> curLevel =new ArrayList<Integer>();
			int currentSize=q.size();//2.1ȡ��ǰ��size q��size��һֱ�ڱ仯��
			for (int i = 0; i < currentSize; i++) {
				TreeNode a= q.poll();//2.2��������
				curLevel.add(a.val);//��ӡ�����Ľڵ�
				if(a.left!= null) {
					q.offer(a.left);//2.3������ѹ�����ҽڵ�
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
