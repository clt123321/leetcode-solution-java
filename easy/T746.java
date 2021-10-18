package easy;

public class T746 {
	/*
	 * ��Ŀ���ƣ�ʹ����С������¥��
	 * �� i �����ݶ�Ӧ��һ���Ǹ�������������ֵ cost[i]���±�� 0 ��ʼ��
	 * �ȸ����������󵽴�̨�ף�Ȼ����Ϳ���ѡ��������һ�����ݻ������������ݡ�
     * ��ﵽ¥�㶥������ͻ��ѡ��ڿ�ʼʱ�������ѡ����±�Ϊ 0 �� 1 ��Ԫ����Ϊ��ʼ���ݡ�
	 * 
	 * ���룺cost = [10, 15, 20]
     * �����15
     * ���ͣ���ͻ����Ǵ� cost[1] ��ʼ��Ȼ�����������ɵ����ݶ���һ������ 15 ��
	 * 
	 * 
	 * ��̬�滮�ⷨ dp�����¼״̬���������⣩
	 * ˼���������⣺
	 * 1dp[i]�Ķ���
	 *   �����i��̨�׻������ٵ�����ֵ��dp[i]
	 * 2�ݹ鹫ʽ ״̬ת�Ʒ���
	 *    dp[i]=min{dp[i-1],dp[i-2]}+cos[i];
	 * 3��ʼ��
	 *    dp[0]=cos[0];dp[1]=cos[1];
	 * 4ȷ������˳��
	 *    �ӵ��ƹ�ʽ�п��Կ�������֮ǰ�����飬��˴�ǰ�������
	 * 5�����Ƶ�dp����
	 */
	public static void main(String[] args) {
		int [] cost= {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
		System.out.println(minCostClimbingStairs(cost));
		
	}
	//ע��˴����һ�����ǲ���Ҫ�����ģ���һ����Ҫ���� ��Ҳ���Է��������
	public static int minCostClimbingStairs(int[] cost) {
	    int a=cost.length;
		int[]dp=new int[a];
		dp[0]=cost[0];
		dp[1]=cost[1];
		for (int i = 2; i < dp.length; i++) {
			dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
		}
		return Math.min(dp[a-2], dp[a-1]);

    }
}
