package medium;

public class T494 {
	/*
	 * 目标和（中等）
	 * 给你一个整数数组 nums 和一个整数 target
	 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 
	 * 返回可以使最终数组和为⽬标数 S 的所有添加符号的⽅法数。
	 * 
	 * 既然为target，那么就⼀定有 left组合 - right组合 = target。
	 * left + right等于sum，⽽sum是固定的。
	 * 公式来了， left - (sum - left) = target -> left = (target + sum)/2 。
	 * 问题转化成：在nums中求和为left的组合
	 * 
	 * dp[i]:填满容量为i的包有几种方法
	 * 递推公式：不考虑nums[i]的情况下，有dp[j-nums[i]]种方法，
	 * 为了得到dp[j],需要对所有的nums[i]累加.
	 * 
	 * 初始化：dp[0]=1;其他为0
	 */
	public static void main(String[] args) {
		int[]nums = {1,1,1,1,1};
	    int target = 3;
	    System.out.println(findTargetSumWays(nums, target));
		
	}
	public static int findTargetSumWays(int[] nums, int target) {
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		if (target > sum||-target>sum) return 0; //注意target为负的情况
		if ((target + sum) % 2 == 1) return 0; 
		int left=(target+sum)/2;
		
		int[]dp=new int[left+1];
		dp[0]=1;
		for (int i = 0; i < nums.length; i++) {//外层正序遍历物品
			for (int j = left ; j >= nums[i]; j--) {//内层逆序遍历容量dp数组
				dp[j] += dp[j - nums[i]];//组合类问题通式
			}
		}
		return dp[left];
	

    }

}
