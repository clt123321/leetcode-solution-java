package medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class T39 {
	/*
	 * 组合总和2(不重复的正数数组 无限制拿，求和为目标值的集合个数)
	 * 回溯
	 * 
	 * 注意到和是累加的，因此终止递归的条件是大于sum
	 * 注意到是可以使用重复元素的，因此递归中使用的是当前元素
	 * 
	 * 可以剪枝优化
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
			backtracking(candidates, target, ans, combine, i, sum);//i表示可以重复使用当前元素
			sum -= candidates[i]; //消除上一次深度搜索的影响
			combine.removeLast();
		}	
	}
}
