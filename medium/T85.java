package medium;

public class T85 {
	/*题目名称：最大矩形(困难)
	 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，
	找出只包含 1 的最大矩形，并返回其面积。
	*/
	public static void main(String[] args) {
		char[][]matrix= {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'},
		};
		System.out.println(maximalRectangle(matrix));
	}
	public static int maximalRectangle(char[][] matrix) {
		int rows = matrix.length;
	    if(rows==0)  return 0;
	    int columns = matrix[0].length;
	    int [][] dp = new int [rows][columns];
	    //求长度
	    for(int i = 0; i < matrix.length; i++){
	        for(int j = 0; j < matrix[0].length; j++){
	            if(matrix[i][j]=='1'){
	                dp[i][j] = j==0?1:dp[i][j-1]+1;
	            }
	        }
	    }
	    int area = 0;
	    //求面积
	    for(int i = 0;i<rows;i++){
	        for(int j = 0; j < columns;j++){ 
	            if(matrix[i][j] =='0')  continue;
	            int len = dp[i][j];
	            for(int k = i;k>=0&&matrix[k][j]=='1';k--){//求高
	                len = Math.min(len,dp[k][j]);//得到长度
	                area = Math.max(area,(i-k+1)*len);
	            }
	        }
	    }
	    return area;
}
}
