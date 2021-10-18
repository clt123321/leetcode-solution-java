package medium;

public class T343 {
	/* ��Ŀ���ƣ��������(�е�)
	 * ��Ŀ����������һ�������� n��������Ϊ���������������ĺͣ�
	 * ��ʹ��Щ�����ĳ˻���󻯡� ��������Ի�õ����˻���
	 * ����: 2
             ���: 1
             ����: 2 = 1 + 1, 1 �� 1 = 1��
       ps:n ��С�� 2 �Ҳ����� 58��
             
     * ��̬�滮�ⷨ dp�����¼״̬
	 * 1dp[i]�Ķ���
	 *   �ֲ�����i�õ������˻�dp[i]
	 * 2�ݹ鹫ʽ ״̬ת�Ʒ���
	 *    ��Ҫ�¶���һ������j����1��ʼ����
	 *    ���Էָ�����i���õ�����j��i-j��
	 *    Math.max(j*(i-j),j*(dp[i-j]));
	 *    �����е��и��dp[i]���ҵ����dp[i]
	 *    dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*(dp[i-j])));
	 * 3��ʼ��
	 *    ��ʼ��������Ĳ��֣�������dp[2]=1
	 * 4ȷ������˳��  
	 *    �ӵ��ƹ�ʽ�п��Կ�������֮ǰ�����飬��˴�ǰ�������
	 * 5�����Ƶ�dp����
	 */
	 public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
	 public static int integerBreak(int n) {
		 int [] dp=new int[n+1];
		 dp[2]=1;
		 for (int i = 3; i <= n; i++) {
			 for (int j = 0; j <i ; j++) {//j<i-1 ���ڹ��dp[1](��Ȼ�����������),j<iҲ�ɣ�dp[1]=0��
				 dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*(dp[i-j])));
			}
		}
		return dp[n];
	  }
}
