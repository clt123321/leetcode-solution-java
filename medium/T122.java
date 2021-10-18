package medium;

public class T122 {
	/*
	 * ������Ʊ�����ʱ��2
	 * prices[i]�ǹ�Ʊ��i��ļ۸�
	 * ����㷨��ȡ��������(ֻ��һֻ��Ʊ)
	 * 
	 * 
	 * ��ֵõ��������У�ѡ�����е����������䡣
	 * �ֲ��������ռ�ÿ���������
	 *
	 */
	public static void main(String[] args) {
		int[] nums= {7,1,5,3,6,4};
    	int[] nums1= {7,6,4,3,1};
    	
		System.out.println(maxProfit(nums));
		System.out.println(maxProfit(nums1));
		
	}
	public static int maxProfit(int[] prices) {
		int ans=0;
		for (int i = 0; i < prices.length-1; i++) {
			ans+=Math.max(prices[i+1]-prices[i],0);
		}
		return ans;
    }

}
