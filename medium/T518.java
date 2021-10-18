package medium;

public class T518 {
	/*
	 * 零钱兑换2（中等）
	 * 分析：
	 * dp[i]是凑成和为i的组合数
	 * 递推公式：对所有的i累加——dp[j]+=dp[j-coins[i]]
	 * 初始化：dp[0]=1;其他为0，这样不影响累加
	 * 
	 * 注意完全背包问题两层循环都是正向的
	 * 同时外层物体内层容量的循环表示组合数(不强调顺序)
	 * 反之是排列数（强调排列顺序）
	 * 
	 * 顺序问题：01背包和完全背包都是可以交换顺序的（次序不重要）
	 * 
	 */
	public static void main(String[] args) {
		int amount = 5;
		int []coins = {1, 2, 5};
		System.out.println(change(amount,coins));
		
	}
	public static int change(int amount, int[] coins) {
		int[] dp=new int[amount+1];
		dp[0]=1;
		for (int i = 0; i < coins.length; i++) {//遍历物品
			for (int j = coins[i]; j<dp.length;j++) {//遍历容量
				dp[j]+=dp[j-coins[i]];
			}
		}
        return dp[amount];
    }
	
	

}
