package medium;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class T139 {
	/*
	 * 单词拆分（中等）
	 * 给定⼀个⾮空字符串 s 和⼀个包含⾮空单词的列表 wordDict，
	 * 判定 s 是否可以被空格拆分为⼀个或多个在字典中出现的单词。
	 * 
	 * 分析：
	 * dp[i] : 字符串⻓度为i的话，dp[i]为true，表示可以拆分为⼀个或多个在字典中出现的单词。
	 * 递推公式：if([j, i] 这个区间的⼦串出现在字典⾥ && dp[j]是true 则dp[i]=true
	 * dp[0]=true
	 * 组合和排序都可以，但是推荐
	 *
	 */
	public static void main(String[] args) {
		ArrayList<String> a=new ArrayList<String>();
		a.add("code");
		a.add("leet");
		String s="leetcode";
		System.out.println(wordBreak(s,a));
	}
	public static boolean wordBreak(String s, ArrayList<String> wordDict) {
		HashSet<String> wordSet=new HashSet<String>(wordDict);
		boolean[]dp=new boolean[s.length()+1];
		dp[0]=true;
		for (int i = 1; i < dp.length; i++) {//背包
			for (int j = 0; j < i; j++) {//物品
				String word=s.substring(j,i);
				if (wordSet.contains(word)&& dp[j]) {
					 dp[i] = true;
			     }
			}
		}
		return dp[s.length()];
    }

}
