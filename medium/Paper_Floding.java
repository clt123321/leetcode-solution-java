package medium;

public class Paper_Floding {
	/*
	 * �ۺ۷�������
	 * ��һ��ֽ��ͬһ���򷴸�����a�Σ���չ�����ۺ۵ĳ���
	 * ת��Ϊ���������������
	 * ���У�ͷ����ǰ��ģ���������ͷ����ǰ�����������ͷ�����͹
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
		System.out.print(down?"��":"͹");
		printprocess(x+1, a, false);
	}

}
