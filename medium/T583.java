package medium;
/*
 * �����ַ�����ɾ���������еȣ�
 * ������������ word1 �� word2���ҵ�ʹ�� word1 �� word2 ��ͬ�������С������ÿ������ɾ������һ���ַ����е�һ���ַ���
 * �൱��115��s��t������ɾ��
 * 
 * ������
 * dp[i][j]����i-1Ϊ��β���ַ���word1������j-1λ��β���ַ���word2��
 * ��Ҫ�ﵽ��ȣ�����Ҫɾ��Ԫ�ص����ٴ�����
 * ��s[i-1] == t[j-1];dp[i][j] = dp[i - 1][j - 1];
 * �����ȷ����������ȡ��Сֵ
 * dp[i][j]=Math.min(dp[i-1][j-1]+2,dp[i-1][j]+1,dp[i][j-1]+1);
 * 
 * ��ʼ����һ�㿼�ǵ�һ�к͵�һ��
 * dp[0][i]=dp[i][0]=i;
 */

public class T583 {
	public static void main(String[] args) {
		String s1 = "sea";
		String s2 = "eat";
		System.out.println(minDistance(s1, s2));
	}
	public static int minDistance(String word1, String word2) {
		int[][] dp =new int[word1.length()+1][word2.length()+1];
		
		for (int i = 0; i < word1.length()+1; i++) {
			dp[i][0]=i;
		}	
		for (int j = 1; j <word2.length()+1; j++) {
			dp[0][j]=j;
		}
		
		
		for (int i = 1; i <word1.length()+1; i++) {
			for (int j = 1; j < word2.length()+1; j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+2,dp[i-1][j]+1),dp[i][j-1]+1);
			}
		}
		return dp[word1.length()][word2.length()];
    }

}
