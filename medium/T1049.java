package medium;

public class T1049 {
	/*
	 * 最后一块石头的重量（中等）
	 * 1 <= stones.length <= 30，1 <= stones[i] <= 1000
	 * 
	 * 分析：
	 * 和T416完全一致
	 * 题物品的重量为store[i]，物品的价值也为store[i]
	 * dp[i]是容量为i的包最多可以放的价值
	 * 递推关系：dp[j] = max(dp[j], dp[j - stones[i]] + stones[i]);
	 * 初始化：全部为0
	 */
	public static void main(String[] args) {
		
		int []stones = {2,7,4,1,8,1};
		System.out.println(lastStoneWeightII(stones));
		
	}
	public static int lastStoneWeightII(int[] stones) {
		int[]dp=new int[15000];
		int sum=0;
		for (int i = 0; i < stones.length; i++) {
			sum+=stones[i];
		}
		int target=sum/2;
		for (int i = 0; i < stones.length; i++) {//外层正序遍历物品
			for (int j = target; j >= stones[i]; j--) {//同理需要反向迭代
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return sum-2*dp[target];
    }
}
