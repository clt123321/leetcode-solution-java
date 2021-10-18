package medium;
import java.io.ObjectInputStream.GetField;

public class JZ13 {
/*
 * 题目名称：机器人的运动范围（中等）
 * 题目描述：m列n行的方格，机器人从（0,0）开始运动，每次可以向上下左右移动一个格；
 * 不能移动出矩阵，也不能进入行列坐标位数之和大于k的格子。输出能到达的格子数量。
 * 
 *输入：m = 2, n = 3, k = 1
 *输出：3
 *输入：m = 3, n = 1, k = 0
 *输出：1
 *
 *ps:1 <= n,m <= 100
 *0 <= k <= 20
 */
	
	
    public static void main(String[] args) {
		//int x=123;
		//System.out.println(sum(x));
    	System.out.println(movingCount(2, 3, 1));
    	System.out.println(movingCount(3, 1, 0));
	}
    public static int sum(int x) {//计算各位数之和
		int res=0;
		while(x!=0) {
			res += x%10;//取余
			x/=10;
		}
		return res;
	}
	public static int movingCount(int m, int n, int k) {
		//深度优先搜索， 只用搜索右和下两个方向
		boolean[][] visit=new boolean[m][n];
		return dfs(0,0,m,n,k,visit);
    }
	public static int dfs(int i, int j, int m, int n, int k, boolean[][] visit) {
		//1递归基  确定边界  并从边界处往回走
		if(i>=m || j>=n || sum(i)+sum(j)>k ||visit[i][j]) {
			return 0;
		}
		visit[i][j] =true;
		//2只用搜索右和下两个方向; 类似二叉树的 merge
		return 1+dfs(i+1, j, m, n, k, visit)+dfs(i, j+1, m, n, k, visit);
	} 
}
