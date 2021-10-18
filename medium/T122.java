package medium;

public class T122 {
	/*
	 * 买卖股票的最佳时机2
	 * prices[i]是股票第i天的价格
	 * 设计算法获取最大的利益(只有一只股票)
	 * 
	 * 
	 * 差分得到利润序列，选择所有的正利润区间。
	 * 局部最优是收集每天的正利润
	 *
	 */
	public static void main(String[] args) {
		int[] nums= {7,1,5,3,6,4};
    	int[] nums1= {7,6,4,3,1};
    	
		System.out.println(maxProfit(nums));
		System.out.println(maxProfit(nums1));
		
	}
	public static int maxProfit(int[] prices) {
		int ans=0;
		for (int i = 0; i < prices.length-1; i++) {
			ans+=Math.max(prices[i+1]-prices[i],0);
		}
		return ans;
    }

}
