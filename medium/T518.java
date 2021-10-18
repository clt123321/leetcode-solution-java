package medium;

public class T518 {
	/*
	 * ��Ǯ�һ�2���еȣ�
	 * ������
	 * dp[i]�Ǵճɺ�Ϊi�������
	 * ���ƹ�ʽ�������е�i�ۼӡ���dp[j]+=dp[j-coins[i]]
	 * ��ʼ����dp[0]=1;����Ϊ0��������Ӱ���ۼ�
	 * 
	 * ע����ȫ������������ѭ�����������
	 * ͬʱ��������ڲ�������ѭ����ʾ�����(��ǿ��˳��)
	 * ��֮����������ǿ������˳��
	 * 
	 * ˳�����⣺01��������ȫ�������ǿ��Խ���˳��ģ�������Ҫ��
	 * 
	 */
	public static void main(String[] args) {
		int amount = 5;
		int []coins = {1, 2, 5};
		System.out.println(change(amount,coins));
		
	}
	public static int change(int amount, int[] coins) {
		int[] dp=new int[amount+1];
		dp[0]=1;
		for (int i = 0; i < coins.length; i++) {//������Ʒ
			for (int j = coins[i]; j<dp.length;j++) {//��������
				dp[j]+=dp[j-coins[i]];
			}
		}
        return dp[amount];
    }
	
	

}
