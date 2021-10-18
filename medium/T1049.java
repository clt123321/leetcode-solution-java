package medium;

public class T1049 {
	/*
	 * ���һ��ʯͷ���������еȣ�
	 * 1 <= stones.length <= 30��1 <= stones[i] <= 1000
	 * 
	 * ������
	 * ��T416��ȫһ��
	 * ����Ʒ������Ϊstore[i]����Ʒ�ļ�ֵҲΪstore[i]
	 * dp[i]������Ϊi�İ������Էŵļ�ֵ
	 * ���ƹ�ϵ��dp[j] = max(dp[j], dp[j - stones[i]] + stones[i]);
	 * ��ʼ����ȫ��Ϊ0
	 */
	public static void main(String[] args) {
		
		int []stones = {2,7,4,1,8,1};
		System.out.println(lastStoneWeightII(stones));
		
	}
	public static int lastStoneWeightII(int[] stones) {
		int[]dp=new int[15000];
		int sum=0;
		for (int i = 0; i < stones.length; i++) {
			sum+=stones[i];
		}
		int target=sum/2;
		for (int i = 0; i < stones.length; i++) {//������������Ʒ
			for (int j = target; j >= stones[i]; j--) {//ͬ����Ҫ�������
				dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
			}
		}
		return sum-2*dp[target];
    }
}
