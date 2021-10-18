package medium;

public class T63 {
	/*
	 * ��Ŀ���ƣ���ͬ·��2���еȣ�
	 * m*n�ľ��󣬴����Ͻǳ�����ֻ�����»������ƶ�һ������ͼ�������½ǣ�
	 * �����е��ϰ���Ϳ�λ�÷ֱ��� 1 �� 0 ����ʾ��
	 * ���ز�ͬ��·��������
	 * 
	 * ���룺obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * �����2
	 * 
	 * �ⷨ1
	 * ��̬�滮�ⷨ dp�����¼״̬���������⣩
	 * ˼���������⣺
	 * 1dp[i][j]�Ķ���
	 *   ����(0,0)����������(i��j)��dp[i][j]����ͬ��·
	 * 2�ݹ鹫ʽ ״̬ת�Ʒ���
	 *    dp[i][j]=dp[i-1][j]+dp[i][j-1];(�������ϰ���Ӧ��ʼ��Ϊ0)
	 * 3��ʼ��
	 *    ��0�к͵�һ�ж���1,���ϰ�֮��ĵط���ӦΪ0����
	 * 4ȷ������˳��
	 *    �ӵ��ƹ�ʽ�п��Կ�������֮ǰ�����飬��˴�ǰ�������
	 * 5�����Ƶ�dp����
	 * 
	 */

	public static void main(String[] args) {
		int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePaths(obstacleGrid));
	}
	public static int uniquePaths(int[][]obstacleGrid) {
		//��ʼ��
		int [][]dp=new int[obstacleGrid.length][obstacleGrid[0].length];
		for(int i=0;i<obstacleGrid.length && obstacleGrid[i][0]!=1;i++) {
			dp[i][0]=1;
		}
		for(int j=0;j<obstacleGrid[0].length && obstacleGrid[0][j]!=1;j++) {
			dp[0][j]=1;
		}
		//����dp
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(obstacleGrid[i][j]==1)continue;
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
			}
		}
	    return dp[dp.length-1][dp[0].length-1];
	}

}
