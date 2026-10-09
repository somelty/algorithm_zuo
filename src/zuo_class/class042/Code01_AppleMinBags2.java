package zuo_class.class042;

//有装下8个苹果的袋子、装下6个苹果的袋子，一定要保证买苹果时所有使用的袋子都装满
//对于无法装满所有袋子的方案不予考虑，给定n个苹果，返回至少要多少个袋子
//如果不存在每个袋子都装满的方案返回-1
public class Code01_AppleMinBags2 {
	
	public static int bags1(int apple) {
		int ans = f(apple);
		return ans == Integer.MAX_VALUE? -1: ans;
	}
	
	public static int f(int rest) {
		
		if (rest == 0) return 0;
		if (rest < 0) return Integer.MAX_VALUE; 
		int p1 = f(rest - 8);
		int p2 = f(rest - 6);
		p1 += f(rest - 8) == Integer.MAX_VALUE? 0: 1;
		p2 += f(rest - 6) == Integer.MAX_VALUE? 0: 1;
		return Math.min(p1, p2);
	}
	
	public static void main(String[] args) {
		for (int apple = 0; apple < 100; apple++) {
			System.out.println(apple + " : " + bags1(apple));
		}
	}
	
}
