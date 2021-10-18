package medium;



public class T213 {
	/*
	 * 打家劫舍（中等）   类似题目t198  区别在于此处小区是成环的
	 * 如果两间相邻的房屋在同⼀晚上被⼩偷闯⼊，系统会⾃动报警。
	 * 给定⼀个代表每个房屋存放⾦额的⾮负整数数组，计算你 不触动警报装置的情况下 ，⼀夜之内能够偷窃到的最⾼⾦额。
	 * 
	 * 考虑两种情况（含头和不含头）
	 * 
	 * 注意输入的合法性
	 */
	public static void main(String[] args) {
		int[] nums= {1,2,3,1};
		int[] nums1= {2,3,2};
		System.out.println(rob(nums));
		System.out.println(rob(nums1));
	}
	
	public static int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int result1 = rob198(nums, 0, nums.length - 2); // 情况一
		int result2 = rob198(nums, 1, nums.length - 1); // 情况二
		return Math.max(result1, result2);
	}
	public static int rob198(int[] nums,int begin,int end) {
		if(begin ==  end)return nums[begin];
		int[]dp=new int[nums.length];
		dp[begin]=nums[begin];
		dp[begin+1]=Math.max(nums[begin],nums[begin+1]);
		for (int i = begin+2; i <= end; i++) {
			dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
		}
		return dp[end];
    }
}
