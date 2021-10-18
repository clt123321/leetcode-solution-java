package easy;

public class T509 {
	/*
	 * 题目名称：斐波拉契亚数列（简单）
	 * 计算数列中第n个数
	 * 动态规划解法 dp数组
	 * 
	 * 思考如下问题：
	 * 1dp[i]的定义
	 *   第i个斐波拉契的数值是dp[i]
	 * 2递归公式 状态转移方程
	 * 3初始化
	 * 4确定遍历顺序
	 *    从递推公式中可以看出依赖之前的数组，因此从前往后遍历
	 * 5举例推导dp数组
	 */
	
	public static void main(String[] args) {
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(10));
		
		System.out.println(fib1(0));
		System.out.println(fib1(1));
		System.out.println(fib1(2));
		System.out.println(fib1(3));
		System.out.println(fib1(4));
		System.out.println(fib1(10));
	}
	public static int fib(int n) {
		if (n<=1) {
			return n;
		}
		//1dp数组初始化
		int[]dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		
		//2动归  需要从2开始迭代，顺序是从前往后
		for (int i = 2; i <= n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
	    return dp[n];
    }
	
	
	//优化空间复杂度 只用保留两个数值
	public static int fib1(int n) {
		if (n<=1) {
			return n;
		}
		//2dp数组初始化
		int[]dp=new int[2];
		dp[0]=0;
		dp[1]=1;
		
		//3动归  需要从2开始迭代，顺序是从前往后
		for (int i = 2; i <= n; i++) {
			int sum= dp[0]+dp[1];
			dp[0]=dp[1];
			dp[1]=sum;
		}
	    return dp[1];
    }

}
