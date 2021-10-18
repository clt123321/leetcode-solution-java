package medium;

public class T85 {
	/*��Ŀ���ƣ�������(����)
	 * ����һ�������� 0 �� 1 ����СΪ rows x cols �Ķ�ά�����ƾ���
	�ҳ�ֻ���� 1 �������Σ��������������
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
	    //�󳤶�
	    for(int i = 0; i < matrix.length; i++){
	        for(int j = 0; j < matrix[0].length; j++){
	            if(matrix[i][j]=='1'){
	                dp[i][j] = j==0?1:dp[i][j-1]+1;
	            }
	        }
	    }
	    int area = 0;
	    //�����
	    for(int i = 0;i<rows;i++){
	        for(int j = 0; j < columns;j++){ 
	            if(matrix[i][j] =='0')  continue;
	            int len = dp[i][j];
	            for(int k = i;k>=0&&matrix[k][j]=='1';k--){//���
	                len = Math.min(len,dp[k][j]);//�õ�����
	                area = Math.max(area,(i-k+1)*len);
	            }
	        }
	    }
	    return area;
}
}
