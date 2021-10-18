package medium;

public class T416 {
	/*
	 * 分割等和子集（中等）
	 * 给定⼀个只包含正整数的⾮空数组。是否可以将这个数组分割成两个⼦集，
	 * 使得两个⼦集的元素和相等。
	 * 
	 * 分析：
	 * 背包的体积为sum / 2
	 * 背包要放⼊的商品（集合⾥的元素）重量为 元素的数值，价值也为元素的数值
	 * 背包如何正好装满，说明找到了总和为 sum / 2 的⼦集。
	 * 背包中每⼀个元素是不可重复放⼊
	 * 
	 * 
	 * dp定义为：容量为i的包，最多能装的价值为dp[i]
	 * 递推：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
	 * 
	 * 1 <= nums.length <= 200
	 * 1 <= nums[i] <= 100
	 * 总和不超过20000,背包的一半取10001即可
	 */
	public static void main(String[] args) {
		int[] input= {1, 5, 11, 5};
		System.out.println(canPartition(input));
		int[] input1= {1, 2, 3, 4};
		System.out.println(canPartition(input1));
	}
	public static boolean canPartition(int[] nums) {
		int sum=0;
		int[]dp=new int[10001];
		for (int i = 0; i < nums.length; i++) {
			 sum += nums[i];
		}
		if (sum % 2 == 1) return false;
	    int target = sum / 2;
	    System.out.println(target);
	    
	    for (int i = 0; i < nums.length; i++) {
			for (int j = target; j >= nums[i]; j--) {//不可重新放入，需要从大到小
				dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
			}
		}
	    if (dp[target] == target) return true;
	    return false;
    }

}
