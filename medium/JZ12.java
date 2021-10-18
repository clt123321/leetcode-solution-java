package medium;
public class JZ12 {
	/*
	 * 题目名称：矩阵中的路径
	 * 题目描述：判断一个字符矩阵中是否包含一个字符串上所有的路径。
	 * 路径：从任意格子开始，每一步向上下左右移动一格。
	 * ps：不能重复使用格子。
	 *输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	 *输出：true
	 *
	 *典型的矩阵搜索问题. DFS+剪枝
     */
	
	public static boolean exist(char[][] board, String word) {
		char[] words=word.toCharArray();
		//1对于矩阵内每一个字符，都作为起始搜一遍
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				//2递归 参数为ijk,k为words第几个元素。
				if(SearchMatrix(board,words,i,j,0))return true;
			}
		}
		return false;
    }
	 private static boolean SearchMatrix(char[][] board, char[] words, int i, int j, int k) {
		//2.1递归基
		if(k==words.length) {//第一次出错words.length-1
			System.out.println("\n"+ "route:");
			showChar2D(board);
			return true;//完全匹配
		}
		if(i>=board.length|| j>=board[0].length||i<0||j<0)return false;//行列超过边界
		if(board[i][j]!=words[k])return false;//当前位置字符不匹配
		
		//2.2 标记访问
		board[i][j]='\0';//空置字符 表示已经访问过 也方便可视化
		
		//2.3更新参数ijk,递归判断上下左右 
		boolean tmp=false;
		tmp= SearchMatrix(board, words, i+1, j, k+1)||SearchMatrix(board, words, i, j+1, k+1)
				||SearchMatrix(board, words, i-1, j, k+1)||SearchMatrix(board, words, i, j-1, k+1);
		board[i][j]=words[k];//是必要的，第二处错误
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
		 
		 //第一次未通过的一个用例
		 char[][] board2 = {{'A'}};
		 String word2 = "AB";
		 showChar2D(board2);
		 System.out.println(exist(board2,word2));
		 
		 
		//第二次未通过的一个用例
		 char[][] board3 = {{'C','A','A'},{'A','A','A'},{'B','C','A'}};
		 String word3 = "AAB";
		 showChar2D(board3);
		 System.out.println(exist(board3,word3));
	}
	 //可视化
	 public static void showChar2D(char[][] arr) {
		 for(int j=0;j< arr.length;j++) {
			for (int i = 0; i < arr[0].length; i++) {
				System.out.print(arr[j][i]+",");
			}
			System.out.println("");
		 }
		}	
}
