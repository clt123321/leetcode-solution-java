package medium;
/*
 * 最长公共子数组（中等）
 * 对于两个考察对象
 * dp应该为二维数组，dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最⻓重复⼦数组⻓度为dp[i][j]。
 * 
 * 递推公式if(nums1[i] == nums2[j]) dp[i][j]=dp[i-1][j-1]+1;
 * 找dp的最大值
 * 
 * 初始化：dp[i][0]= dp[0][j] =0
 */

public class T718 {
	public static void main(String[] args) {
		int[]a= {1,2,3,2,1};
		int[]b= {3,2,1,4,7};
		System.out.println(findLength(a,b));
	}
	 public static int findLength(int[] nums1, int[] nums2) {
		 int[][]dp=new int[nums1.length+1][nums2.length+1];
		 int dpmax=0;
		 for (int i = 1; i < nums1.length+1; i++) {
			 for (int j = 1; j < nums2.length+1; j++) {
				 if(nums1[i-1] == nums2[j-1]) {
					 dp[i][j]=dp[i-1][j-1]+1;
				 }
				 if(dp[i][j]>dpmax)dpmax=dp[i][j];
			}
			
		}
		return dpmax;
	 }

}
