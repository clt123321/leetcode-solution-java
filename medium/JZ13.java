package medium;
import java.io.ObjectInputStream.GetField;

public class JZ13 {
/*
 * ��Ŀ���ƣ������˵��˶���Χ���еȣ�
 * ��Ŀ������m��n�еķ��񣬻����˴ӣ�0,0����ʼ�˶���ÿ�ο��������������ƶ�һ����
 * �����ƶ�������Ҳ���ܽ�����������λ��֮�ʹ���k�ĸ��ӡ�����ܵ���ĸ���������
 * 
 *���룺m = 2, n = 3, k = 1
 *�����3
 *���룺m = 3, n = 1, k = 0
 *�����1
 *
 *ps:1 <= n,m <= 100
 *0 <= k <= 20
 */
	
	
    public static void main(String[] args) {
		//int x=123;
		//System.out.println(sum(x));
    	System.out.println(movingCount(2, 3, 1));
    	System.out.println(movingCount(3, 1, 0));
	}
    public static int sum(int x) {//�����λ��֮��
		int res=0;
		while(x!=0) {
			res += x%10;//ȡ��
			x/=10;
		}
		return res;
	}
	public static int movingCount(int m, int n, int k) {
		//������������� ֻ�������Һ�����������
		boolean[][] visit=new boolean[m][n];
		return dfs(0,0,m,n,k,visit);
    }
	public static int dfs(int i, int j, int m, int n, int k, boolean[][] visit) {
		//1�ݹ��  ȷ���߽�  ���ӱ߽紦������
		if(i>=m || j>=n || sum(i)+sum(j)>k ||visit[i][j]) {
			return 0;
		}
		visit[i][j] =true;
		//2ֻ�������Һ�����������; ���ƶ������� merge
		return 1+dfs(i+1, j, m, n, k, visit)+dfs(i, j+1, m, n, k, visit);
	} 
}
