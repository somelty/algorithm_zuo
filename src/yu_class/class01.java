package yu_class;

public class class01 {
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int ans1 = sum(10000000);
		long end = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		int ans2 = sum2(10000000);
		long end2 = System.currentTimeMillis();
		
		System.out.println(end - start);
		System.out.println(end2 - start2);
		
	}
	
	public static int sum(int n) {
		if (n == 1) return 1;
		else {
			return n + sum(n - 1);
		}
		
	}
	
	public static int sum2(int n) {
		int s = 0;
		for (int i = 1; i <= n; i ++) {
			s = s + i;
		}

		return s;
	}
}
