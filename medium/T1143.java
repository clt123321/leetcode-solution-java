package medium;
/*
 * 最长公共子序列（中等）
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 和718区别 离散的也可以
 * 
 * dp[i][j]：⻓度为[0, i - 1]的字符串text1与⻓度为[0, j - 1]的字符串text2的最⻓公共⼦序列为dp[i][j]
 * 递推公式：dp[i][j] = dp[i - 1][j - 1] + 1
 *         dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
 * 
 * 初始化:全部是0
 */

public class T1143 {
	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(longestCommonSubsequence(text1, text2));
	
	}
	public static int longestCommonSubsequence(String text1, String text2) {
		 int[][]dp=new int[text1.length()+1][text2.length()+1];
		 
		 for (int i = 1; i < text1.length()+1; i++) {
			for (int j = 1; j < text2.length()+1; j++) {
				if(text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		 
		return dp[text1.length()][text2.length()];
    }
}
