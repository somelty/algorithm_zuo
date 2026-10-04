package zuo_class.class040;

public class NQueens {

	// N皇后问题
	// 测试链接 : https://leetcode.cn/problems/n-queens-ii/
	
	// 方法一：数组方法，有寻址过程更慢
	public static int totalNQueens1(int n) {
		if (n < 1) return 0;
		return f1(0, new int[n], n);
	}
	
	public static int f1(int i, int[] path, int n) {
		if (i == n) return 1;
		int ans = 0;
		for (int j = 0; j < n; j++) {
			if (check(i, j, path)) {
				path[i] = j;
				ans += f1(i + 1, path, n);
			}
		}
		return ans;
	}
	
	public static boolean check(int i, int j, int[] path) {
		for(int k = 0; k < i; k ++) {
			if (j == path[k] || Math.abs(k - i) == Math.abs(j - path[k])) {
				return false;
			}
		}
		return true;
	}
	
	// 方法二：位运算版本
	public static int totalNQueens2(int n) {
		if(n < 1) return 0;
		int limit = (1 << n) - 1;
		return f2(limit, 0, 0, 0);
	}
	
	public static int f2(int limit, int col, int l, int r) {
		if (col == limit)return 1;
		int ban = (col | l | r);
		int can = limit & (~ban);
		int ans = 0;
		while(can != 0) {
			int place = can & (-can);
			can ^= place;
			ans += f2(limit, (col | place), (l | place)<<1, (r | place)>>1);
		}
		return ans;
	}
}
