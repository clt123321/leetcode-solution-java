package medium;

public class T1035 {
	/*
	 * ���ཻ���ߣ��еȣ�
	 * �����������飬���ȷֲ�����������ֱ���ϣ���ͬ��Ԫ�ؿ�������
	 * �һ��Ƶ�ֱ�߲����κ��������ߣ���ˮƽ�ߣ��ཻ��
	 * ��ע�⣬���߼�ʹ�ڶ˵�Ҳ�����ཻ��ÿ������ֻ������һ�����ߡ������ַ������������������ؿ��Ի��Ƶ����������
	 * 
	 * ��̬�滮
	 * ����Ĺ������ַ���
	 * dp[i][j]��ʾ�±�i-1,j-1֮ǰ���ַ�������������ַ�������
	 * ���ƹ�ʽ��if(nums1[i-1] == nums2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
	 *           else dp[i][j]= Math.max(dp[i-1][j],dp[j][j-1])  
	 *��ʼ�� dp = 0;           
	 *˳�����
	 * 
	 */
	public static void main(String[] args) {
		int []nums1 = {1,4,2};
		int []nums2 = {1,2,4};
		//return 2
		System.out.println(maxUncrossedLines(nums1, nums2));
	}
	
	public static int maxUncrossedLines(int[] nums1, int[] nums2) {
		int[][] dp=new int[nums1.length+1][nums2.length+1];
		for (int i = 1; i < nums1.length+1; i++) {
			for (int j = 1; j < nums2.length+1; j++) {
				if(nums1[i-1] == nums2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[nums1.length][nums2.length];
    }

}
