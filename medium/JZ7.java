package medium;
import java.util.HashMap;
/**
 * ��Ŀ���ƣ��ؽ����������еȣ�
 * ��Ŀ������������������ǰ������������������ö�����������ͷ��㡣
 * ps����������û���ظ�Ԫ��
 * ���ӣ�
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {//ע�������java����һ���ӿ� ��Ҫ����дһ��
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class JZ7 {
	
    /*����ǰ�������root����Ȼ��(preorder[0])����˽�����ת��Ϊ������������.
	 * ���ֱ��������λ���Ե�
	 */
     //1�������������hashmap ������ң������ظ�Ԫ�أ�
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return rebuild(0, 0, inorder.length - 1,preorder);  
    }
    /*pre_root_index : ���ڵ� �� ǰ������е��±�
     in_left_index: �ýڵ�����������е���߽�
     in_right_index: �ýڵ�����������е��ұ߽� */ 
    public static TreeNode rebuild(int pre_root_index, 
    		int in_left_index, int in_right_index,int[] preorder){
	//2 ����ݹ��
       if(in_left_index > in_right_index)  return null;

    //3�������ҵ����ڵ�������������
       int rootValue=preorder[pre_root_index];
       int in_root_index = map.get(rootValue);
       
       TreeNode node = new TreeNode(rootValue);

    //4 ���ҽڵ�Ķ��壨����������ͷ��㣩
       node.left = rebuild(pre_root_index + 1, 
    		   in_left_index, in_root_index - 1,preorder);
       
       //System.out.println(pre_root_index + in_root_index - in_left_index + 1);
       node.right = rebuild(pre_root_index + in_root_index - in_left_index + 1, 
    		   in_root_index + 1, in_right_index,preorder);
       return node;
    }

    public static void main(String[] args) {
		int[] preorder= {3,9,20,15,7};
		int[] inorder= {9,3,15,20,7};
		show(buildTree(preorder,inorder));
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
