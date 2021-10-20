package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class T39 {
	/*
	 * ����ܺ�2(���ظ����������� �������ã����ΪĿ��ֵ�ļ��ϸ���)
	 * ����
	 * 
	 * ע�⵽�����ۼӵģ������ֹ�ݹ�������Ǵ���sum
	 * ע�⵽�ǿ���ʹ���ظ�Ԫ�صģ���˵ݹ���ʹ�õ��ǵ�ǰԪ��
	 * 
	 * ���Լ�֦�Ż�
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<Integer> combine = new LinkedList<Integer>();
        backtracking(candidates, target, ans, combine, 0,0);
        return ans;
    }
	public static void backtracking(int[] candidates, int target,List<List<Integer>> ans, Deque<Integer> combine,int startIndex,int sum) {
		if(sum > target) {
			return;
		}
		if (sum == target) {
			ans.add(new ArrayList<Integer>(combine));
			return;
		}
		
		for (int i = startIndex; i < candidates.length; i++) {
			sum += candidates[i];
			combine.addLast(candidates[i]);
			backtracking(candidates, target, ans, combine, i, sum);//i��ʾ�����ظ�ʹ�õ�ǰԪ��
			sum -= candidates[i]; //������һ�����������Ӱ��
			combine.removeLast();
		}	
	}
}
