package medium;

public class Paper_Floding {
	/*
	 * 折痕方向问题
	 * 将一张纸朝同一方向反复对折a次，求展开后折痕的朝向
	 * 转化为二叉树的中序遍历
	 * 其中，头结点是凹的，左子树的头结点是凹，右子树的头结点是凸
	 */
	public static void main(String[] args) {
		int a=5;
		printAllFlods(a);
	}

	private static void printAllFlods(int a) {
		printprocess(1,a,true);
	}

	private static void printprocess(int x,int a,boolean down) {
		if(x>a)return;
		printprocess(x+1, a, true);
		System.out.print(down?"凹":"凸");
		printprocess(x+1, a, false);
	}

}
