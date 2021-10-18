package easy;

public class T509 {
	/*
	 * ��Ŀ���ƣ�쳲����������У��򵥣�
	 * ���������е�n����
	 * ��̬�滮�ⷨ dp����
	 * 
	 * ˼���������⣺
	 * 1dp[i]�Ķ���
	 *   ��i��쳲���������ֵ��dp[i]
	 * 2�ݹ鹫ʽ ״̬ת�Ʒ���
	 * 3��ʼ��
	 * 4ȷ������˳��
	 *    �ӵ��ƹ�ʽ�п��Կ�������֮ǰ�����飬��˴�ǰ�������
	 * 5�����Ƶ�dp����
	 */
	
	public static void main(String[] args) {
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(10));
		
		System.out.println(fib1(0));
		System.out.println(fib1(1));
		System.out.println(fib1(2));
		System.out.println(fib1(3));
		System.out.println(fib1(4));
		System.out.println(fib1(10));
	}
	public static int fib(int n) {
		if (n<=1) {
			return n;
		}
		//1dp�����ʼ��
		int[]dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		
		//2����  ��Ҫ��2��ʼ������˳���Ǵ�ǰ����
		for (int i = 2; i <= n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
	    return dp[n];
    }
	
	
	//�Ż��ռ临�Ӷ� ֻ�ñ���������ֵ
	public static int fib1(int n) {
		if (n<=1) {
			return n;
		}
		//2dp�����ʼ��
		int[]dp=new int[2];
		dp[0]=0;
		dp[1]=1;
		
		//3����  ��Ҫ��2��ʼ������˳���Ǵ�ǰ����
		for (int i = 2; i <= n; i++) {
			int sum= dp[0]+dp[1];
			dp[0]=dp[1];
			dp[1]=sum;
		}
	    return dp[1];
    }

}
