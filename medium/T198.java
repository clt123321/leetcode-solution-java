package medium;

import java.awt.Robot;

public class T198 {
	/*
	 * 打家劫舍（中等）   类似题目t213
	 * 如果两间相邻的房屋在同⼀晚上被⼩偷闯⼊，系统会⾃动报警。
	 * 给定⼀个代表每个房屋存放⾦额的⾮负整数数组，计算你 不触动警报装置的情况下 ，⼀夜之内能够偷窃到的最⾼⾦额。
	 * 
	 * dp[i]表示第i家打劫的最多数目
	 * 递推公式有dp[i]=max(dp[i-2]+num[i],dp[i-1]);
	 * 初始化为：dp[0]=nums[0]
	 * dp[1]=Math.max(nums[0],nums[1]);
	 * 一层循环即可，从前往后
	 * 
	 * 注意输入的合法性
	 */
	public static void main(String[] args) {
		int[] nums= {1,2,3,1};
		int[] nums1= {2,7,9,3,1};
		System.out.println(rob(nums));
		
	}
	public static int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int[]dp=new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0],nums[1]);
		for (int i = 2; i < dp.length; i++) {
			dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
		}
		return dp[dp.length-1];

    }

}
