package medium;
/*
 * �����ִ����еȣ�
 * ����һ���ַ��� s ������ͳ�Ʋ���������ַ����� �����Ӵ� ����Ŀ��
 * 
 * ����boolean[][]dp����ʾ��i��j��������ַ����Ƿ��ǻ��Ĵ�
 * ���ƹ�ʽ��
 * if(s[i]==s[j])
 * 	if(j-i<=1){
 *     ans++;
 * 	   dp[i][j]=true;
 * 	}else if(dp[i+1][j-1])
 * {
 *      ans++;
 * 	    dp[i][j]=true;
 * }
 * else
 * dp[i][j]=false
 */

public class T647 {
	public static void main(String[] args) {
		String s1="aaa";
		System.out.println(countSubstrings(s1));
	}
	public static int countSubstrings(String s) {
		boolean[][] dp=new boolean[s.length()][s.length()];
		int ans=0;
		for (int j = 0; j < s.length(); j++) {
			for (int i = j; i >=0; i--) {
				if(s.charAt(i)==s.charAt(j))
					 if(j-i<=1){
					    ans++;
					    dp[i][j]=true;
					 }else if(dp[i+1][j-1]){
					       ans++;
					  	   dp[i][j]=true;
					  }
				 
			     else {
					 dp[i][j]=false;
			     }
		     }
        }
		return ans;
	}

}
