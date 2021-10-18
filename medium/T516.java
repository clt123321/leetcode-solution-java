package medium;
/*
 * 最长的回文子序列（中等）
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 注意子序列可以不连续
 * 
 * 定义int[][]dp 表示【i，j】之间最长的回文子序列长度
 * if(s.CharAt(i)==s.CharAt(j)){
 *    dp[i][j]= dp[i+1][j-1]+2; 
 * }
 * else{
 *    Math.max(dp[i][j-1],dp[i+1][j]);
 * }
*/

public class T516 {
	public static void main(String[] args) {
		String s1="bbbab";
		System.out.println(longestPalindromeSubseq(s1));
	}
	public static int longestPalindromeSubseq(String s) {
		int[][] dp=new int[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			dp[i][i]=1;
		}
		for (int i = s.length()-1; i >= 0; i--) {
			for (int j = i+1; j <s.length(); j++) {
				if(s.charAt(i)==s.charAt(j)){
					 dp[i][j]= dp[i+1][j-1]+2; 
				}
				else{
					dp[i][j]= Math.max(dp[i][j-1],dp[i+1][j]);
				}
			}
	    }
		return dp[0][s.length()-1];
    }

}
