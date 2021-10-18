package medium;

public class T62 {
	/*
	 * 题目名称：不同路径（中等）
	 * m*n的矩阵，从左上角出发，只能向下或向右移动一步，试图到达右下角，
	 * 返回不同的路径数量。
	 * 
	 * 输入：m = 3, n = 7
     * 输出：28
	 * 
	 * 解法1
	 * 动态规划解法 dp数组记录状态（花费问题）
	 * 思考如下问题：
	 * 1dp[i][j]的定义
	 *   从是(0,0)出发，到达(i，j)有dp[i][j]条不同的路
	 * 2递归公式 状态转移方程
	 *    dp[i][j]=dp[i-1][j]+dp[i][j-1];
	 * 3初始化
	 *    第0列和第一行都是1
	 * 4确定遍历顺序
	 *    从递推公式中可以看出依赖之前的数组，因此从前往后遍历
	 * 5举例推导dp数组
	 * 
	 *  本质上是斐波拉契数列的二位情形
	 */
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(3,7));
	}
	//解法1 复杂度 O(m*n)
	public static int uniquePaths(int m, int n) {
		int[][] dp= new int[m][n];
		for(int i=0;i<m;i++) {
			dp[i][0]=1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j]=1;
		}
		
		for (int i=1;i<m;i++) {
			for (int j =1; j < n; j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
    }	
	//解法2 深搜 走过的路径可以抽象为二叉树
	//注意：该解法可能会超时，因为遍历了满二叉树，复杂度为2^n,不可接受
	public static int uniquePaths1(int m, int n) {
		return dfs(0,0,m,n);
    }	
	public static int dfs(int i,int j,int m,int n) {
		//定义递归基
		if (i>=m||j>=n) {
			return 0;
		}
		if (i==m-1&&j==n-1) {
			return 1;
		}
		return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
	}
	
	
	

}
