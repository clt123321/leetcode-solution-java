package easy;

public class T70 {
	/*
	 * ��Ŀ���ƣ���¥�ݣ��򵥣�
	 * һ����һ��������̨�� �ж����ַ������Ե�n��̨��
	 * ps��n��������
	 *
	 * ��̬�滮�ⷨ dp����
	 * 
	 * ˼���������⣺
	 * 1dp[i]�Ķ���
	 *   ������i��¥�ݵķ�������dp[i]
	 * 2�ݹ鹫ʽ ״̬ת�Ʒ���
	 *   dp[i]=dp[i-1]+dp[i-2]
	 * 3��ʼ��
	 *   dp[1]=1;dp[2]=2;
	 * 4ȷ������˳��
	 *    �ӵ��ƹ�ʽ�п��Կ�������֮ǰ������Ԫ�أ���˴�ǰ�������
	 * 5�����Ƶ�dp����
	 *     쳲���������
	 *
	 */
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(5));
		
		
        System.out.println(climbStairsPlus(5,2));
	}
	 public static int climbStairs(int n) {
		 if(n<=1)return n;
		 int[]dp=new int[n+1];
			dp[1]=1;
			dp[2]=2;
		 for (int i = 3; i <= n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		 return dp[n];
	    }
	 
	 
	 
	 //��չ����һ�ο�����һ��������������̨�� ֱ��m��̨�ף�m=2 �����ϵ�������
	 public static int climbStairsPlus(int n,int m) {
		 //if(n<=1)return n;
		 int[]dp=new int[n+1];
			dp[0]=1;
		for (int i = 0; i <=n; i++) {//������
			for (int j = 1; j <= m;j++) {//����Ʒ  ��������
				if(i-j>=0)dp[i]+=dp[i-j];
			}
		}
		 return dp[n];
	    }
}
