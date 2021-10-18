package medium;

public class T62 {
	/*
	 * ��Ŀ���ƣ���ͬ·�����еȣ�
	 * m*n�ľ��󣬴����Ͻǳ�����ֻ�����»������ƶ�һ������ͼ�������½ǣ�
	 * ���ز�ͬ��·��������
	 * 
	 * ���룺m = 3, n = 7
     * �����28
	 * 
	 * �ⷨ1
	 * ��̬�滮�ⷨ dp�����¼״̬���������⣩
	 * ˼���������⣺
	 * 1dp[i][j]�Ķ���
	 *   ����(0,0)����������(i��j)��dp[i][j]����ͬ��·
	 * 2�ݹ鹫ʽ ״̬ת�Ʒ���
	 *    dp[i][j]=dp[i-1][j]+dp[i][j-1];
	 * 3��ʼ��
	 *    ��0�к͵�һ�ж���1
	 * 4ȷ������˳��
	 *    �ӵ��ƹ�ʽ�п��Կ�������֮ǰ�����飬��˴�ǰ�������
	 * 5�����Ƶ�dp����
	 * 
	 *  ��������쳲��������еĶ�λ����
	 */
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(3,7));
	}
	//�ⷨ1 ���Ӷ� O(m*n)
	public static int uniquePaths(int m, int n) {
		int[][] dp= new int[m][n];
		for(int i=0;i<m;i++) {
			dp[i][0]=1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j]=1;
		}
		
		for (int i=1;i<m;i++) {
			for (int j =1; j < n; j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
		return dp[m-1][n-1];
    }	
	//�ⷨ2 ���� �߹���·�����Գ���Ϊ������
	//ע�⣺�ýⷨ���ܻᳬʱ����Ϊ�������������������Ӷ�Ϊ2^n,���ɽ���
	public static int uniquePaths1(int m, int n) {
		return dfs(0,0,m,n);
    }	
	public static int dfs(int i,int j,int m,int n) {
		//����ݹ��
		if (i>=m||j>=n) {
			return 0;
		}
		if (i==m-1&&j==n-1) {
			return 1;
		}
		return dfs(i+1,j,m,n)+dfs(i,j+1,m,n);
	}
	
	
	

}
