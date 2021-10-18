package medium;
/*
 * 回文字串（中等）
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 
 * 定义boolean[][]dp，表示【i，j】区间的字符串是否是回文串
 * 递推公式：
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
