package easy;

public class T72 {
	/*
	 * 求一个整数的平方根整数部分
	 * 0 <= x <= 2^31 - 1
	 * */
	public static void main(String[] args) {
		System.out.println(mySqrt(888));
	}
	public static int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long tmp = (long) mid * mid;
            if (tmp == x) return mid;
            else if (tmp > x) r = mid - 1;
            else l = mid + 1;
        }
        return l - 1;
    }
}
