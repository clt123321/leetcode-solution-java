package hard;
/*
 * 不同的子序列（困难）
 * 给定一个字符串 s 和一个字符串 t ，
 * 计算在 s 的子序列中 t 出现的个数。
 * s可以删除，t不可以删除
 * 
 * 分析：
 * 这道题⽬如果不是⼦序列，⽽是要求连续序列的，
 * 那就可以考虑⽤KMP。
 * 动态规划：
 * dp[i][j]：以i-1为结尾的s⼦序列中出现以j-1为结尾的t的个数为dp[i][j]。
 * if(s[i-1] == t[j-1]){
 * dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
 * }
 * else dp[i][j] = dp[i-1][j]
 *
 *初始化：dp[i][0]=1;因为可以删除掉所有的s
 *
 *返回最后一个dp
 * 
 */

public class T115 {
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		System.out.println(numDistinct(s, t));
	}
	public static int numDistinct(String s, String t) {
		int[][] dp =new int[s.length()+1][t.length()+1];
		
		for (int i = 0; i < s.length()+1; i++) {
			dp[i][0]=1;
		}
		
		for (int i = 1; i <s.length()+1; i++) {
			for (int j = 1; j < t.length()+1; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				}
				else dp[i][j] = dp[i-1][j];
			}
		}
		return dp[s.length()][t.length()];
    }

}
