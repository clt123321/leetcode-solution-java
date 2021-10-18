package medium;

public class T376 {
	/*
	 * �ڶ����У��еȣ�
	 * ����Ĳ�ֵ�������͸���֮�佻��ĳ�Ϊ�ڶ�����
	 * һ��Ԫ�ط���1
	 * ������ͬԪ��һ�µ�����Ҳ��
	 * ����ɾ�������е�һЩԪ�أ�����Ԫ�ر���˳������İڶ����С�
	 * 
	 * ˼·���ֲ�������ɾ�������¶��ϵ��м�ڵ㣬�������ľֲ���ֵ
	 * ʵ�ʲ���������ֻҪͳ�ƾֲ���ֵ����������
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
		int curDiff=0;//��ǰ�Ĳ�ֵ
		int preDiff=0;//��һ�ԵĲ�ֵ
		int numPeak=1;//�������
		
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
