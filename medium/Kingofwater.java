package medium;
import java.util.HashMap;

public class Kingofwater {
	public static void main(String[] args) {
		int[] arr= {1,1,1,2,2,2,2,2,3,6,4,3,1,2,4,35,64,4};
		show(arr);
		System.out.println(verify(arr));
		System.out.println(waterking(arr));
	}
	public static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+",");
		}
	}
		
	public static int verify(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		
		HashMap<Integer,Integer> map=new HashMap<>();
		//1.给每个数建立词频
		for(int num : arr) {
			if(map.containsKey(num))
				map.put(num,map.get(num)+1);
			else {
				map.put(num,1);
			}
		}
		
		int N=arr.length;
		for(java.util.Map.Entry<Integer, Integer> record : map.entrySet()) {
			if(record.getValue()>(N>>1))
				return record.getKey();
		}
		return -1;
	}
	
	public static int waterking(int[] arr) {
		if(arr==null || arr.length==0) {
			return -1;
		}
		int candidate =0;
		int hp=0;
		for(int num :arr) {
			if(hp==0) {//2.1没有候选则当前立即为候选 
				candidate=num;
				hp=1;
			}else if(num!=candidate) {//2.2不一样则湮灭
				hp--;
			}else {//2.3 一样则加厚
				hp++;
			}
		}
		if(hp==0) {//3.1遍历后全部湮灭则无水王  实则给出的是一个必要不充分条件
			return -1;
		}
		
		//3.2湮灭后剩余的需要精细判断一下 如{1,2,3,4,5}剩余5
		int count=0;
		for(int cur:arr) {
			if(cur==candidate)
				count++;
		}
		if(count>(arr.length>>1))
			return candidate;
		else 
			return -1;
	}


}
