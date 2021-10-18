package hard;
/*
 * 元素为目标值的子矩阵数量（困难）
 * 前缀和
 * 
 * 确定一个子矩阵的方式：先用两个变量确定上下边界，
 * 使用hashmap确定左右边界：
 * 具体操作：迭代列，作差得到cur，在hashmap中寻找key，使得 cur - x = targetcur−x=target
 * 
 * key：作差的cur值
 * value：cur出现的次数
 * 
 * 时间复杂度：O(m * n^2)
 * 暴力复杂度：（m*n）^2
 */

import java.util.HashMap;

public class T1074 {
	 public int numSubmatrixSumTarget(int[][] mat, int t) {
	        int n = mat.length, m = mat[0].length;
	      //1迭代 获得前缀和矩阵
	        int[][] sum = new int[n + 1][m + 1];
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= m; j++) {
	                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
	            }
	        }
	      
	        
	     //2 确定上下边界
	        int ans = 0;
	        for (int top = 1; top <= n; top++) {
	            for (int bottom = top; bottom <= n; bottom++) {
	                int cur = 0;
	                HashMap<Integer, Integer> map = new HashMap<>();
	                for (int r = 1; r <= m; r++) {
	                    cur = sum[bottom][r] - sum[top - 1][r];
	                    if (cur == t) ans++;
	                    if (map.containsKey(cur - t)) ans += map.get(cur - t);//若差值为t，则
	                    map.put(cur, map.getOrDefault(cur, 0) + 1);//方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值0
	                }
	            }
	        }
	        return ans;
	    }

}
