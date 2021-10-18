package easy;

public class T746 {
	/*
	 * 题目名称：使用最小花费爬楼梯
	 * 第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）
	 * 先付出体力，后到达台阶，然后你就可以选择向上爬一个阶梯或者爬两个阶梯。
     * 求达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
	 * 
	 * 输入：cost = [10, 15, 20]
     * 输出：15
     * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
	 * 
	 * 
	 * 动态规划解法 dp数组记录状态（花费问题）
	 * 思考如下问题：
	 * 1dp[i]的定义
	 *   到达第i个台阶花费最少的体力值是dp[i]
	 * 2递归公式 状态转移方程
	 *    dp[i]=min{dp[i-1],dp[i-2]}+cos[i];
	 * 3初始化
	 *    dp[0]=cos[0];dp[1]=cos[1];
	 * 4确定遍历顺序
	 *    从递推公式中可以看出依赖之前的数组，因此从前往后遍历
	 * 5举例推导dp数组
	 */
	public static void main(String[] args) {
		int [] cost= {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
		
	}
	//注意此处最后一步都是不需要体力的，第一步需要体力 。也可以反过来理解
	public static int minCostClimbingStairs(int[] cost) {
	    int a=cost.length;
		int[]dp=new int[a];
		dp[0]=cost[0];
		dp[1]=cost[1];
		for (int i = 2; i < dp.length; i++) {
			dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
		}
		return Math.min(dp[a-2], dp[a-1]);

    }
}
