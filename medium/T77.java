package medium;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.events.StartDocument;

public class T77 {
	/*
	 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
	 * 你可以按 任何顺序 返回答案。
	 * 回溯算法第一题
	 * 
	 * 模板：
	 * void backtracking(参数){
	 * if(终止条件){
	 *  存放结果
	 *  return
	 * }
	 * for(本层集合中元素，){//横向遍历
	 * 	处理节点；
	 *   backtracking（路径，参数）//下一层
	 *   回溯，撤销处理结果
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
		if(cur.size() == k) {//终止条件
			ans.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i =startIndex; i <=n; i++) {//横向的宽度
			cur.addLast(i);
			backtracking(n,k,i+1,ans,cur);//设置搜索的起点是i+1
			cur.removeLast();
		}
	}

}
