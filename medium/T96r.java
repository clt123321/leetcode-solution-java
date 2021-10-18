package medium;

public class T96r {
	/* 题目名称：不同的二叉搜索树（中等）
	 * 题目描述：给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的
	 * 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
	 * 
	 * 搜索树：左小于根小于右
	     输入：n = 3
             输出：5
             
             子树的结构和 规模相似的子问题结构是一样的  
     *注意到 dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
     *dp[i] += dp[以j为头结点左⼦树节点数量] * dp[以j为头结点右⼦树节点数量]  
     *
     *      
     * 动态规划解法 dp数组记录状态
	 * 1dp[i]的定义
	 *   i个元素可以组成dp[i]中种不同的二叉树
	 * 2递归公式 状态转移方程
	 *    需要新定义一个变量j，从1开始遍历
	 *    可以分割数字i，得到两段j和i-j；
	 *    dp[i]=sum(dp[j-1]*dp[i-j]);
	 * 3初始化
	 *    dp[0]=1; dp[1]=1;
	 * 4确定遍历顺序  
	 *    从递推公式中可以看出依赖之前的数组，因此从前往后遍历
	 * 5举例推导dp数组
	 */
	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
	 public static int numTrees(int n) {
		 int []dp=new int[n+1];
		 dp[0]=1; dp[1]=1;
		 for (int i = 2; i <= n; i++) {
		 	for (int j = 1; j <= i; j++) {
			 dp[i]+=dp[j-1]*dp[i-j];
		     }
		 }
		 return dp[n];
	 }
}
