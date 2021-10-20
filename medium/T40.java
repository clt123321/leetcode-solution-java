package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T40 {
	/*
	 * 组合总和3(重复的正数数组 只能拿，求和为目标值的集合个数
	 * 1本题candidates 中的每个数字在每个组合中只能使⽤⼀次。
	 * 2本题数组candidates的元素是有重复的
	 * 
	 * 回溯问题的应用
	 * 
	 * 退出条件和T39相同
	 * 重点考察如何判断同⼀树层上元素（相同的元素）是否使⽤过了（去重）
	 * 
	 */
	public static void main(String[] args) {
		int []candidates = {10,1,2,7,6,1,5};
		int target = 8;
		combinationSum2(candidates,target);
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<Integer> combine = new LinkedList<Integer>();
        boolean[] isused = new boolean[candidates.length];
        
        Arrays.sort(candidates);//先排序，保证相同元素一定出现在前面
        backtracking(candidates, target, ans, combine, 0,0,isused);
        return ans;
    }
	public static void backtracking(int[] candidates, int target,List<List<Integer>> ans, Deque<Integer> combine,int startIndex,int sum,boolean[] isused) {
		if (sum == target) {
			ans.add(new ArrayList<Integer>(combine));
			return;
		}
		
		for (int i = startIndex; i < candidates.length && sum + candidates[i]<=target; i++) {
			//去重
			if(i>0 && candidates[i]==candidates[i-1] && isused[i-1]==false) {
				continue;
			}
			sum += candidates[i];
			combine.addLast(candidates[i]);
			isused[i]=true; //表示当前i已经被使用，下层搜索中不能出现
			backtracking(candidates, target, ans, combine, i+1, sum,isused);//i+1表示不可以重复使用当前元素
			//消除上一次深度搜索的影响
			isused[i]=false; 
			sum -= candidates[i]; 
			combine.removeLast();
		}	
	}

}
