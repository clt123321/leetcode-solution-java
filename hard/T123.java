package hard;
/*
 * 买卖股票3(困难)
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 分析：每天中有五种不同的状态
 * 0操作 dp[i][j] =dp[i-1][0];
 * 1 第一次买入 dp[i][j] = max(dp[i-1][1],dp[i-1][0]-prices[i]);
 * 2 第一次卖出 dp[i][j] = max(dp[i-1][2],dp[i-1][1]+prices[i]);
 * 3 第一次买入
 * 4 第二次卖出
 * 
 * 初始化：明显是第一列
 * 
 */

public class T123 {
	public static void main(String[] args) {
		int[] p= {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(p));
		
	}
	public static int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][5];
		dp[0][0]=0;
		dp[0][1]=-prices[0];
		dp[0][2]=0;
		dp[0][3]=-prices[0];
		dp[0][4]=0;
		for (int i = 1; i < dp.length; i++) {
			dp[i][0]= dp[i-1][0];
			dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
			dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
			dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
			dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
			
		}
		return dp[dp.length-1][4];
		
    }	
}
