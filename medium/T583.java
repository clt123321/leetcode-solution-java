package medium;
/*
 * 两个字符串的删除操作（中等）
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 相当于115中s和t都可以删除
 * 
 * 分析：
 * dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，
 * 想要达到相等，所需要删除元素的最少次数。
 * 若s[i-1] == t[j-1];dp[i][j] = dp[i - 1][j - 1];
 * 若不等分三种情况，取最小值
 * dp[i][j]=Math.min(dp[i-1][j-1]+2,dp[i-1][j]+1,dp[i][j-1]+1);
 * 
 * 初始化，一般考虑第一行和第一列
 * dp[0][i]=dp[i][0]=i;
 */

public class T583 {
	public static void main(String[] args) {
		String s1 = "sea";
		String s2 = "eat";
		System.out.println(minDistance(s1, s2));
	}
	public static int minDistance(String word1, String word2) {
		int[][] dp =new int[word1.length()+1][word2.length()+1];
		
		for (int i = 0; i < word1.length()+1; i++) {
			dp[i][0]=i;
		}	
		for (int j = 1; j <word2.length()+1; j++) {
			dp[0][j]=j;
		}
		
		
		for (int i = 1; i <word1.length()+1; i++) {
			for (int j = 1; j < word2.length()+1; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+2,dp[i-1][j]+1),dp[i][j-1]+1);
			}
		}
		return dp[word1.length()][word2.length()];
    }

}
