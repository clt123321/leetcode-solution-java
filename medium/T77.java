package medium;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.events.StartDocument;

public class T77 {
	/*
	 * ������������ n �� k�����ط�Χ [1, n] �����п��ܵ� k ��������ϡ�
	 * ����԰� �κ�˳�� ���ش𰸡�
	 * �����㷨��һ��
	 * 
	 * ģ�壺
	 * void backtracking(����){
	 * if(��ֹ����){
	 *  ��Ž��
	 *  return
	 * }
	 * for(���㼯����Ԫ�أ�){//�������
	 * 	����ڵ㣻
	 *   backtracking��·����������//��һ��
	 *   ���ݣ�����������
	 * }
	 * }
	 */
	

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ans= new ArrayList<List<Integer>>();
		Deque<Integer> cur = new LinkedList<Integer>();
		backtracking(n, k, 1, ans,cur);
		return ans;
    }
	
	public static void backtracking(int n,int k,int startIndex,List<List<Integer>> ans,Deque<Integer> cur){
		if(cur.size() == k) {//��ֹ����
			ans.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i =startIndex; i <=n; i++) {//����Ŀ��
			cur.addLast(i);
			backtracking(n,k,i+1,ans,cur);//���������������i+1
			cur.removeLast();
		}
	}

}
