package medium;
//��ά�����еĲ��ң��������飩

public class JZ1 {
	public static void main(String[] args) {
		int[][] arr= {
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		int[][] arr1= {
				{1,1}
		};
		//System.out.println(arr[0][2]);
		System.out.println(Find(2,arr1));
		System.out.println(Find(7,arr));
		System.out.println(Find(5,arr));
	}
     public static boolean Find(int target, int [][] array) {
    	 //1ѡȡ�������Ͻǵ������ȱȽ�
    	 //2����ͬ���ҵ���������Ҫ���ҵ����֣��������в��ҷ�Χ���޳�һ�У���С��Ҫ���ҵ����֣����޳�һ�У�
    	 //3��ʣ��������Χ�е����ò���
    	 boolean found=false;
    	 if(array!=null && array.length!=0) {
    		 int column=array[0].length;//��
        	 int row=array.length;//��
        	 
        	 
        	 int i=0;
        	 int j=column-1;
        	 

        	 while(i<row && j>=0) {
        		 if(array[i][j]==target) {
        			 found=true;
        			 break;
        		 }
        		 else if (array[i][j]>target) {//ɾһ��
        			 j--;
				}
        		 else {//ɾһ��
        			 i++;
        		 }
        		 System.out.println(i);
        		 System.out.println(j);

        	 }
        	 
    	 }
         return found;
    }
}
