package medium;
//二维数组中的查找（有序数组）

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
    	 //1选取数组右上角的数字先比较
    	 //2若相同，找到；若大于要查找的数字，则在所有查找范围中剔除一列；若小于要查找的数字，则剔除一行；
    	 //3在剩余搜索范围中迭代该操作
    	 boolean found=false;
    	 if(array!=null && array.length!=0) {
    		 int column=array[0].length;//列
        	 int row=array.length;//行
        	 
        	 
        	 int i=0;
        	 int j=column-1;
        	 

        	 while(i<row && j>=0) {
        		 if(array[i][j]==target) {
        			 found=true;
        			 break;
        		 }
        		 else if (array[i][j]>target) {//删一列
        			 j--;
				}
        		 else {//删一行
        			 i++;
        		 }
        		 System.out.println(i);
        		 System.out.println(j);

        	 }
        	 
    	 }
         return found;
    }
}
