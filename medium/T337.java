package medium;

public class T337 {
/*
 * 打家劫舍3
*向左右节点要不同的信息
*dp只有两位
*dp[0]表示不偷该节点的最大金额，dp[1]表示
*
*后序遍历，左右节点的信息迭代父节点
*/
public static void main(String[] args) {
			TreeNode1 root=new TreeNode1(4);
			TreeNode1 L1=new TreeNode1(2);
			TreeNode1 L2=new TreeNode1(1);
			TreeNode1 R1=new TreeNode1(7);
			TreeNode1 R2=new TreeNode1(3);
			root.left=L1;
			root.right=R1;
			L1.left=L2;
			L1.right=R2;
			System.out.println(rob(root));
	}
	
	public static int rob(TreeNode1 root) {
			int[] ans=robTree(root);
			return Math.max(ans[0], ans[1]);
	    }
		
	public static int[] robTree(TreeNode1 cur) {
			int[] zero=new int[2];
			if(cur == null) return zero;//递归基
			
			int[]left= robTree(cur.left);
			int[]right=robTree(cur.right);
			
			//需先得到左右信息 再写递推式
			int[] ans=new int[2];
			ans[1]=cur.val + left[0] + right[0];//偷
		    ans[0]= Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//不偷
		    return ans;
		}
	
}
