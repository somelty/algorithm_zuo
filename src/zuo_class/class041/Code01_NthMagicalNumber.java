package zuo_class.class041;

public class Code01_NthMagicalNumber {

	// 一个正整数如果能被 a 或 b 整除，那么它是神奇的。
	// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。
	// 因为答案可能很大，所以返回答案 对 1000000007 取模
	// 测试链接 : https://leetcode.cn/problems/nth-magical-number/

	public static int nthMagicalNumber(int n, int a, int b) {
		long ans = 0;
		long lcm = lcm(a, b);
		
		
		for (long l = 0, r = (long)n * Math.min(a, b), mid = 0; l<=r;) {
			mid = l+(r-l)/2;
			if(mid/a + mid/b - mid/lcm >= n) {
				ans = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int)(ans % 1000000007);
	}
	
	public static long gcd(long a, long b) {
		return b == 0? a: gcd(b, a%b);
	}
	
	public static long lcm(long a, long b) {
		return (long)a / gcd(a, b) * b;
	}
}

/*
 * 同余原理
 *  
 */
