package easy;

public class T70 {
	/*
	 * 题目名称：爬楼梯（简单）
	 * 一次爬一级或两级台阶 有多少种方法可以到n级台阶
	 * ps：n是正整数
	 *
	 * 动态规划解法 dp数组
	 * 
	 * 思考如下问题：
	 * 1dp[i]的定义
	 *   爬到第i个楼梯的方法数是dp[i]
	 * 2递归公式 状态转移方程
	 *   dp[i]=dp[i-1]+dp[i-2]
	 * 3初始化
	 *   dp[1]=1;dp[2]=2;
	 * 4确定遍历顺序
	 *    从递推公式中可以看出依赖之前的数组元素，因此从前往后遍历
	 * 5举例推导dp数组
	 *     斐波拉契数列
	 *
	 */
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(5));
		
		
        System.out.println(climbStairsPlus(5,2));
	}
	 public static int climbStairs(int n) {
		 if(n<=1)return n;
		 int[]dp=new int[n+1];
			dp[1]=1;
			dp[2]=2;
		 for (int i = 3; i <= n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		 return dp[n];
	    }
	 
	 
	 
	 //拓展：若一次可以爬一级，两级或三级台阶 直到m个台阶（m=2 是以上的特例）
	 public static int climbStairsPlus(int n,int m) {
		 //if(n<=1)return n;
		 int[]dp=new int[n+1];
			dp[0]=1;
		for (int i = 0; i <=n; i++) {//外容量
			for (int j = 1; j <= m;j++) {//内物品  是排列数
				if(i-j>=0)dp[i]+=dp[i-j];
			}
		}
		 return dp[n];
	    }
}
