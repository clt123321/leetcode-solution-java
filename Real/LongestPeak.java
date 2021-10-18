package Real;
/*
 * 求波峰 最长波峰长度   
输入为数组，其子数组s满足length>3,  s[0]<...<s[i]>s[i+1]>...>s[length-1]，即可成为波峰
输入[3,2,5,8,4,3,6]， 则输出为5，因为[2，5，8，4，3]为最长波峰
 */
public class LongestPeak {
	public static void main(String[] args) {
		int[] s = {3,2,5,8,4,3,6,7,8,9};
		System.out.println(LongestPeak(s));
	}
	public static int LongestPeak(int[] s) {
		int[]acc= new int[s.length];
		int position=0;
		int lasti=1;
		int curDiff=0;//当前差距
		int preDiff=0;//之前的差距
	
		for (int i = 0; i < s.length-1; i++) {
			curDiff=s[i+1]-s[i];
			if((curDiff>0&& preDiff<=0)||(curDiff<0&& preDiff>=0) ) {//峰顶和谷底的条件
				//System.out.println(i);  //{0,1,3,5,null}  
				acc[position]= i-lasti+1;//{null,2,3,3}   期望{2,3,3,[2]}
				//System.out.println(acc[position]);
				lasti=i;
				
				position++;
				preDiff=curDiff;
			}
		}
		acc[position]=s.length-lasti;
		
		//求acc[i]+acc[i-1]最大值
		int maxTwo=0;
		for (int i =0; i < acc.length-1; i++) {
			maxTwo=Math.max(maxTwo, acc[i]+acc[i+1]);
		}
		return maxTwo-1;
	}

}
