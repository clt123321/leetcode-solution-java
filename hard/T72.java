package hard;
/*
 * 编辑距离（困难）
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使⽤的最少操作数 。
 * 你可以对⼀个单词进⾏如下三种操作：
 * 插⼊⼀个字符
 * 删除⼀个字符
 * 替换⼀个字符
 * 
 * 定义dp[i][j]示以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2
 * if (word1[i - 1] == word2[j - 1])
 * 不操作
 * if (word1[i - 1] != word2[j - 1])
 * 增
 * 删
 * 换
 * 各对应一个dp
 * 
 * 注意w1删除一个相当于w2增加一个
 * 反之亦然
 * a d
 * ad c
 */

public class T72 {
	public static void main(String[] args) {
		String s1 = "sea";
		String s2 = "eat";
		System.out.println(minDistance(s1, s2));
	}
	public static int minDistance(String word1, String word2) {
		int[][] dp =new int[word1.length()+1][word2.length()+1];
		
		for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
		for (int j = 0; j <= word2.length(); j++) dp[0][j] = j;
		
		for (int i = 1; i <word1.length()+1; i++) {
			for (int j = 1; j < word2.length()+1; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else dp[i][j] =  Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
			}
		}
		return dp[word1.length()][word2.length()];
    }
}

