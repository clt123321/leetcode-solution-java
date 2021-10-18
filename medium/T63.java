package medium;

public class T63 {
	/*
	 * 题目名称：不同路径2（中等）
	 * m*n的矩阵，从左上角出发，只能向下或向右移动一步，试图到达右下角，
	 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
	 * 返回不同的路径数量。
	 * 
	 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
	 * 
	 * 解法1
	 * 动态规划解法 dp数组记录状态（花费问题）
	 * 思考如下问题：
	 * 1dp[i][j]的定义
	 *   从是(0,0)出发，到达(i，j)有dp[i][j]条不同的路
	 * 2递归公式 状态转移方程
	 *    dp[i][j]=dp[i-1][j]+dp[i][j-1];(暗含了障碍处应初始化为0)
	 * 3初始化
	 *    第0列和第一行都是1,但障碍之后的地方都应为0！！
	 * 4确定遍历顺序
	 *    从递推公式中可以看出依赖之前的数组，因此从前往后遍历
	 * 5举例推导dp数组
	 * 
	 */

	public static void main(String[] args) {
		int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePaths(obstacleGrid));
	}
	public static int uniquePaths(int[][]obstacleGrid) {
		//初始化
		int [][]dp=new int[obstacleGrid.length][obstacleGrid[0].length];
		for(int i=0;i<obstacleGrid.length && obstacleGrid[i][0]!=1;i++) {
			dp[i][0]=1;
		}
		for(int j=0;j<obstacleGrid[0].length && obstacleGrid[0][j]!=1;j++) {
			dp[0][j]=1;
		}
		//更新dp
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(obstacleGrid[i][j]==1)continue;
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
	    return dp[dp.length-1][dp[0].length-1];
	}

}
