package medium;

public class T376 {
	/*
	 * 摆动序列（中等）
	 * 数组的差值在正数和负数之间交替的称为摆动序列
	 * 一个元素返回1
	 * 两个不同元素一下的序列也是
	 * 可以删除序列中的一些元素，其他元素保持顺序，求最长的摆动序列。
	 * 
	 * 思路：局部最优是删除单调坡度上的中间节点，保持最多的局部峰值
	 * 实际操作中甚至只要统计局部峰值的数量即可
	 * 
	 */
    public static void main(String[] args) {
    	int[] nums= {1,7,4,9,2,5};
    	int[] nums1= {1,17,5,10,13,15,10,5,16,8};
		System.out.println(wiggleMaxLength(nums));
		System.out.println(wiggleMaxLength(nums1));
	}
	public static int wiggleMaxLength(int[] nums) {
		if(nums.length<=1)return nums.length;
		int curDiff=0;//当前的差值
		int preDiff=0;//上一对的差值
		int numPeak=1;//峰的数量
		
		for (int i = 0; i < nums.length-1; i++) {
			curDiff=nums[i+1]-nums[i];
			if((curDiff>0&& preDiff<=0)||(curDiff<0&& preDiff>=0) ) {
				numPeak++;
				preDiff=curDiff;
			}
		}
		return numPeak;
    }
}
