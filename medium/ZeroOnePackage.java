package medium;

public class ZeroOnePackage {
	/*
	 * 01背包问题
	 * 有N件物品和⼀个最多能被重量为W 的背包。第i件物品的重量是weight[i]，
	 * 得到的价值是value[i] 。每件物品只能⽤⼀次，求解将哪些物品装⼊背包⾥物品价值总和最⼤。
	 * 
	 * dp数组的含义：dp[i][j]表示i个物体里任意取，在背包容量为j时候，最大的价值和
	 * 
	 * 递推公式： dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
	 * 要么最优解中j物体可以被不能被放进去，要么j物体能放进去(腾挪出weight[i]空间)
	 * 
	 * 初始化：dp[i][0]=0;但不用做
	 * 显当 j < weight[0]的时候，dp[0][j] 应该是 0，j之后的可以初始化为weight[0]
	 * 对于i不等于0的行，
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int[] weight= {1,3,4};
		int[] value= {15,20,30};
		int total=4;
		int ans=packagevalue(weight,value,total);
		System.out.println(ans);
	}

	private static int packagevalue(int[] weight, int[] value,int total) {
		int num=weight.length;
		int[][] dp= new int[num][total+1];
		for (int i = weight[0]; i <=total; i++) {
			dp[0][i]=value[0];
		}
		
		for (int i = 1;  i< num; i++) {//遍历物品
			for (int j = 0; j < total+1; j++) {//遍历背包的容量
				if(j < weight[i]) dp[i][j]=dp[i-1][j];//向左看齐(初始化的一部分)
				else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
			}
		}
		show(dp);
		return dp[num-1][total];
	}
	
	public static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+",");
			}
			System.out.println("");
		}
	}
	

}
