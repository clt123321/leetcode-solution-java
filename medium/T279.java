package medium;
import javax.activation.MailcapCommandMap;

public class T279 {
	/*
	 * 完全平方数的数量（中等）
	 * 给定正整数 n，找到若⼲个完全平⽅数（⽐如 1, 4, 9, 16, ...）
	 * 使得它们的和等于 n。你需要让组成和的完全平⽅数的个数最少。
	 * 
	 * 求的是组合最少的数量(也可以是排列，因此内外循环的顺序不重要)
	 * dp[j]：和为j的完全平⽅数的最少数量为dp[j]
	 * 递推公式：dp[j]=min(dp[j-i*i]+1,dp[j])
	 * 初始化：dp[0]=0,dp[ELSE]=MAX
	 */
	public static void main(String[] args) {
		System.out.println(numSquares(13));
		
	}
	public static int numSquares(int n) {
		int[]dp=new int[n+1];
		dp[0]=0;
		for (int i = 1; i < dp.length; i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		for (int i = 1; i *i <= n; i++) {//外物品
			for (int j = 0; j <= n; j++) {//内容量
				if(j-i*i>=0)dp[j]=Math.min(dp[j-i*i]+1, dp[j]);
			}
		}
		return dp[n];
    }
}
