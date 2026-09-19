package leetcode_100.middle;

public class MaxProfit {

	public int maxProfit(int[] prices) {
        int len = prices.length;
		int[] diff = new int[len];
		
		for(int i = 1; i < len; i++) {
			diff[i] = prices[i] - prices[i - 1];
		}
		
		int sum = 0;
		for(int i = 1; i < len; i++) {
            if (diff[i] < 0)diff[i] = 0;
			sum += diff[i];
			
		}
		return sum;
    }
}
