package medium;
import java.util.HashMap;
/**
 * 题目名称：重建二叉树（中等）
 * 题目描述：给出二叉树的前序遍历和中序遍历，求该二叉树，返回头结点。
 * ps：二叉树中没有重复元素
 * 例子：
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

class TreeNode {//注意该类在java中是一个接口 需要重新写一下
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class JZ7 {
	
    /*首先前序遍历的root是显然的(preorder[0])，因此将问题转化为构建左右子树.
	 * 两种遍历次序地位不对等
	 */
     //1将中序遍历归入hashmap 方便查找（不含重复元素）
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return rebuild(0, 0, inorder.length - 1,preorder);  
    }
    /*pre_root_index : 根节点 在 前序遍历中的下标
     in_left_index: 该节点在中序遍历中的左边界
     in_right_index: 该节点在中序遍历中的右边界 */ 
    public static TreeNode rebuild(int pre_root_index, 
    		int in_left_index, int in_right_index,int[] preorder){
	//2 定义递归基
       if(in_left_index > in_right_index)  return null;

    //3中序中找到根节点区分左右子树
       int rootValue=preorder[pre_root_index];
       int in_root_index = map.get(rootValue);
       
       TreeNode node = new TreeNode(rootValue);

    //4 左，右节点的定义（左右子树的头结点）
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
   
	    

  //二叉树树的可视化  Test部分
  	public static void show(TreeNode root) {
          if (root == null){
              System.out.println("EMPTY!");
              return;
          }
          // 得到树的深度
          int treeDepth = getTreeDepth(root);

          // 最后一行的宽度为2的（n - 1）次方乘3，再加1
          // 作为整个二维数组的宽度
          int arrayHeight = treeDepth * 2 - 1;
          int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
          // 用一个字符串数组来存储每个位置应显示的元素
          String[][] res = new String[arrayHeight][arrayWidth];
          // 对数组进行初始化，默认为一个空格
          for (int i = 0; i < arrayHeight; i++) {
              for (int j = 0; j < arrayWidth; j++) {
                  res[i][j] = " ";
              }
          }

          // 从根节点开始，递归处理整个树
          // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
          writeArray(root, 0, arrayWidth / 2, res, treeDepth);

          // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
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
              // 保证输入的树不为空
              if (currNode == null) return;
              // 先将当前节点保存到二维数组中
              res[rowIndex][columnIndex] = String.valueOf(currNode.val);
              // 计算当前位于树的第几层
              int currLevel = ((rowIndex + 1) / 2);
              // 若到了最后一层，则返回
              if (currLevel == treeDepth) return;
              // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
              int gap = treeDepth - currLevel - 1;

              // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
              if (currNode.left != null) {
                  res[rowIndex + 1][columnIndex - gap] = "/";
                  writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
              }
 
              // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
              if (currNode.right != null) {
                  res[rowIndex + 1][columnIndex + gap] = "\\";
                  writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
              }
          }
          
          private static int getTreeDepth(TreeNode root) {
              return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
          }
    
	 
}
