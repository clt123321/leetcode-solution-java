package easy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
题目表述：
重排序arr1，使其满足规则:
	1.和arr2相同的部分按arr2中出现的顺序
	2.不同的部分顺序排列
ps：
1 <= arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
*/
public class T75 {
	public static void main(String[] args) {
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		show(relativeSortArray(arr1,arr2));
		//int[] a=new int[100];
		//show(a);   //数组初始化的内容就是0
	}
	public static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}
	
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] arr = new int[1001];
	    //1统计所有数字的个数 （关键步骤）
	    for (int i = 0; i < arr1.length; i++) {
	        arr[arr1[i]]++;
	    }
	    //2填到第几个数据
	    int index = 0;
	    //3按arr2的顺序，遍历arr。分别填入arr1
	    for (int i = 0; i < arr2.length; i++) {
	        for (int j = 1; j <= arr[arr2[i]]; j++) {
	            arr1[index] = arr2[i];
	            index++;
	        }
	        arr[arr2[i]] = 0;
	    }
	    //4把剩余的数字按顺序填入arr1
	    for (int i = 0; i < arr.length; i++) {
	        for (int j = 1; j <= arr[i]; j++) {
	            arr1[index] = i;
	            index++;
	        }
	    }
	    return arr1;
}
 
	public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
       	Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
      //hashmap 解法
        Integer[] tmp = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.comparingInt(a -> map.getOrDefault(a, a + arr2.length)));
        return Arrays.stream(tmp).mapToInt(a -> a).toArray();
    }

}
