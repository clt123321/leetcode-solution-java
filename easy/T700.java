package easy;
import java.util.Deque;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode() {}
		     TreeNode(int val) { this.val = val; }
		     TreeNode(int val, TreeNode left, TreeNode right) {
		     this.val = val;
		     this.left = left;
		     this.right = right;
		    }
		 }
public class T700 {
	/*
	 * �������е����� 
	 * ����һ��BST�ĸ��ڵ��һ��ֵ������ֵΪ����ֵ�Ľڵ㡣����Ϊnull 
	 * �����������ص㣺��<��<��
	 * ��˶�������������������ͨ�������ǲ�ͬ�ġ�
	 */
	public static void main(String[] args) {
		TreeNode root=new TreeNode(4);
		TreeNode L1=new TreeNode(2);
		TreeNode L2=new TreeNode(1);
		TreeNode R1=new TreeNode(7);
		TreeNode R2=new TreeNode(3);
		root.left=L1;
		root.right=R1;
		L1.left=L2;
		L1.right=R2;
		
		//Deque<E>
		// 6  3 1 7
			
		show(root);
		
		//System.out.println(searchBST(root, 3).val);
	}
	public static TreeNode searchBST(TreeNode root, int val) {
		if(root==null||root.val==val)return root;
		return root.val>val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
	
	
	//���������Ŀ��ӻ�  Test����
  	public static void show(TreeNode root) {
          if (root == null){
              System.out.println("EMPTY!");
              return;
          }
          // �õ��������
          int treeDepth = getTreeDepth(root);

          // ���һ�еĿ��Ϊ2�ģ�n - 1���η���3���ټ�1
          // ��Ϊ������ά����Ŀ��
          int arrayHeight = treeDepth * 2 - 1;
          int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
          // ��һ���ַ����������洢ÿ��λ��Ӧ��ʾ��Ԫ��
          String[][] res = new String[arrayHeight][arrayWidth];
          // ��������г�ʼ����Ĭ��Ϊһ���ո�
          for (int i = 0; i < arrayHeight; i++) {
              for (int j = 0; j < arrayWidth; j++) {
                  res[i][j] = " ";
              }
          }

          // �Ӹ��ڵ㿪ʼ���ݹ鴦��������
          // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
          writeArray(root, 0, arrayWidth / 2, res, treeDepth);

          // ��ʱ���Ѿ���������Ҫ��ʾ��Ԫ�ش��浽�˶�ά�����У�����ƴ�Ӳ���ӡ����
          for (String[] line : res) {
              StringBuilder sb = new StringBuilder();
              for (int i = 0; i < line.length; i++) {
                  sb.append(line[i]);
                  if (line[i].length() > 1 && i <= line.length - 1) {
                      i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                  }
              }
              System.out.println(sb.toString());
          }
  	}
          
          
          private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
              // ��֤���������Ϊ��
              if (currNode == null) return;
              // �Ƚ���ǰ�ڵ㱣�浽��ά������
              res[rowIndex][columnIndex] = String.valueOf(currNode.val);
              // ���㵱ǰλ�����ĵڼ���
              int currLevel = ((rowIndex + 1) / 2);
              // ���������һ�㣬�򷵻�
              if (currLevel == treeDepth) return;
              // ���㵱ǰ�е���һ�У�ÿ��Ԫ��֮��ļ������һ�е��������뵱ǰԪ�ص�������֮��ļ����
              int gap = treeDepth - currLevel - 1;

              // ������ӽ����жϣ���������ӣ����¼��Ӧ��"/"������ӵ�ֵ
              if (currNode.left != null) {
                  res[rowIndex + 1][columnIndex - gap] = "/";
                  writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
              }
 
              // ���Ҷ��ӽ����жϣ������Ҷ��ӣ����¼��Ӧ��"\"���Ҷ��ӵ�ֵ
              if (currNode.right != null) {
                  res[rowIndex + 1][columnIndex + gap] = "\\";
                  writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
              }
          }
          
          private static int getTreeDepth(TreeNode root) {
              return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
          }
			
		
		    
	
		 

}
