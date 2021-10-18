package medium;

public class T377 {
	/*
	 * 给定⼀个由正整数组成且不存在重复数字的数组，找出和为给定⽬标正整数的组合的个数。
	 * 请注意，顺序不同的序列被视作不同的组合
	 * 说明考虑顺序，外容量内物品
	 * 
	 * dp[i]是 凑成⽬标正整数为i的排列个数
	 * 递推公式:dp[i]+=dp[i-nums[j]]
	 * dp[0]要初始化为1
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int target = 4;
		System.out.println(combinationSum4(nums, target));
	}
	public static int combinationSum4(int[] nums, int target) {
		int[]dp=new int[target+1];
		dp[0]=1;
		for (int i = 0 ; i < target+1; i++) {//容量 应该从num[j]开始
			for (int j = 0; j < nums.length; j++) {//物品
				if (i - nums[j] >= 0)
				dp[i]+=dp[i-nums[j]];
			}
		}
		return dp[target];

    }

}
