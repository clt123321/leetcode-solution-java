package medium;

public class T1035 {
	/*
	 * 不相交的线（中等）
	 * 给定两个数组，均匀分布在上下两根直线上，相同的元素可以连线
	 * 且绘制的直线不与任何其他连线（非水平线）相交。
	 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。以这种方法绘制线条，并返回可以绘制的最大连线数
	 * 
	 * 动态规划
	 * 求最长的公共子字符串
	 * dp[i][j]表示下标i-1,j-1之前的字符串的最长公共子字符串数量
	 * 递推公式：if(nums1[i-1] == nums2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
	 *           else dp[i][j]= Math.max(dp[i-1][j],dp[j][j-1])  
	 *初始化 dp = 0;           
	 *顺序遍历
	 * 
	 */
	public static void main(String[] args) {
		int []nums1 = {1,4,2};
		int []nums2 = {1,2,4};
		//return 2
		System.out.println(maxUncrossedLines(nums1, nums2));
	}
	
	public static int maxUncrossedLines(int[] nums1, int[] nums2) {
		int[][] dp=new int[nums1.length+1][nums2.length+1];
		for (int i = 1; i < nums1.length+1; i++) {
			for (int j = 1; j < nums2.length+1; j++) {
				if(nums1[i-1] == nums2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[nums1.length][nums2.length];
    }

}
