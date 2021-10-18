package medium;

public class T343 {
	/* 题目名称：整数拆分(中等)
	 * 题目描述：给定一个正整数 n，将其拆分为至少两个正整数的和，
	 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
	 * 输入: 2
             输出: 1
             解释: 2 = 1 + 1, 1 × 1 = 1。
       ps:n 不小于 2 且不大于 58。
             
     * 动态规划解法 dp数组记录状态
	 * 1dp[i]的定义
	 *   分拆数字i得到的最大乘积dp[i]
	 * 2递归公式 状态转移方程
	 *    需要新定义一个变量j，从1开始遍历
	 *    可以分割数字i，得到两段j和i-j；
	 *    Math.max(j*(i-j),j*(dp[i-j]));
	 *    在所有的切割的dp[i]中找到最大dp[i]
	 *    dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*(dp[i-j])));
	 * 3初始化
	 *    初始化有意义的部分，比如令dp[2]=1
	 * 4确定遍历顺序  
	 *    从递推公式中可以看出依赖之前的数组，因此从前往后遍历
	 * 5举例推导dp数组
	 */
	 public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
	 public static int integerBreak(int n) {
		 int [] dp=new int[n+1];
		 dp[2]=1;
		 for (int i = 3; i <= n; i++) {
			 for (int j = 0; j <i ; j++) {//j<i-1 在于规避dp[1](必然不可能是最大),j<i也可（dp[1]=0）
				 dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*(dp[i-j])));
			}
		}
		return dp[n];
	  }
}
