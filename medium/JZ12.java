package medium;
public class JZ12 {
	/*
	 * ��Ŀ���ƣ������е�·��
	 * ��Ŀ�������ж�һ���ַ��������Ƿ����һ���ַ��������е�·����
	 * ·������������ӿ�ʼ��ÿһ�������������ƶ�һ��
	 * ps�������ظ�ʹ�ø��ӡ�
	 *���룺board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	 *�����true
	 *
	 *���͵ľ�����������. DFS+��֦
     */
	
	public static boolean exist(char[][] board, String word) {
		char[] words=word.toCharArray();
		//1���ھ�����ÿһ���ַ�������Ϊ��ʼ��һ��
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				//2�ݹ� ����Ϊijk,kΪwords�ڼ���Ԫ�ء�
				if(SearchMatrix(board,words,i,j,0))return true;
			}
		}
		return false;
    }
	 private static boolean SearchMatrix(char[][] board, char[] words, int i, int j, int k) {
		//2.1�ݹ��
		if(k==words.length) {//��һ�γ���words.length-1
			System.out.println("\n"+ "route:");
			showChar2D(board);
			return true;//��ȫƥ��
		}
		if(i>=board.length|| j>=board[0].length||i<0||j<0)return false;//���г����߽�
		if(board[i][j]!=words[k])return false;//��ǰλ���ַ���ƥ��
		
		//2.2 ��Ƿ���
		board[i][j]='\0';//�����ַ� ��ʾ�Ѿ����ʹ� Ҳ������ӻ�
		
		//2.3���²���ijk,�ݹ��ж��������� 
		boolean tmp=false;
		tmp= SearchMatrix(board, words, i+1, j, k+1)||SearchMatrix(board, words, i, j+1, k+1)
				||SearchMatrix(board, words, i-1, j, k+1)||SearchMatrix(board, words, i, j-1, k+1);
		board[i][j]=words[k];//�Ǳ�Ҫ�ģ��ڶ�������
		return tmp;
	}
	 
	 
	public static void main(String[] args) {
		 
		 char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		 String word = "ABCCED";
		 System.out.println(word+"\n");
		 showChar2D(board);
		 System.out.println(exist(board,word));
		 
		 
		 char[][] board1 = {{'A','B'},{'C','D'}};
		 String word1 = "ABCD";
		 showChar2D(board1);
		 System.out.println(exist(board1,word1));
		 
		 //��һ��δͨ����һ������
		 char[][] board2 = {{'A'}};
		 String word2 = "AB";
		 showChar2D(board2);
		 System.out.println(exist(board2,word2));
		 
		 
		//�ڶ���δͨ����һ������
		 char[][] board3 = {{'C','A','A'},{'A','A','A'},{'B','C','A'}};
		 String word3 = "AAB";
		 showChar2D(board3);
		 System.out.println(exist(board3,word3));
	}
	 //���ӻ�
	 public static void showChar2D(char[][] arr) {
		 for(int j=0;j< arr.length;j++) {
			for (int i = 0; i < arr[0].length; i++) {
				System.out.print(arr[j][i]+",");
			}
			System.out.println("");
		 }
		}	
}
