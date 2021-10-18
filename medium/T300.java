package medium;

public class T300 {
	/*
	 * 最长的递增子序列（中等）
	 * 给你⼀个整数数组 nums ，找到其中最⻓严格递增⼦序列的⻓度
	 * 删除（或不删除）数组中的元素⽽不改变其余元素的顺序
	 * 
	 * dp[i]表示i之前包括i的最⻓上升⼦序列
	 * 状态转移方程 位置i的最⻓升序⼦序列等于j从0到i-1各个位置的最⻓升序⼦序列 + 1 的最⼤值。
	 * if(nums[i]>nums[j])  dp[i]=Math.max(dp[j]+1,dp[i]); 相当于取dp[j]+1 的最大值
	 * 
	 * 初始值：dp全部为1
	 */
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}
	public static int lengthOfLIS(int[] nums) {
		if(nums.length<=1)return nums.length;
		int[] dp= new int [nums.length];
		for(int i=0;i<dp.length;i++) {
		    dp[i] = 1;
		}
		
		int maxvalue=0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i]>nums[j]) {
					dp[i]=Math.max(dp[j]+1,dp[i]);
				}
			}
			if (maxvalue<dp[i]) {
				maxvalue=dp[i];
			}
		}
		return maxvalue;
    }

}
