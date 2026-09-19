package leetcode_100.easy;

public class MaxProfit {
	
	public static int maxProfit01(int[] prices){
		int len = prices.length;
		int[] diff = new int[len];
		
		for(int i = 1; i < len; i++) {
			diff[i] = prices[i] - prices[i - 1];
		}
		int sumMax = 0;
		int sum = 0;
		for(int i = 1; i < len; i++) {
			sum += diff[i];
			if (sum < 0)sum = 0;//sum<0说明更低的点出现了，sum清零（从最低点开始重新算）
			if (sumMax < sum) sumMax = sum;
		}
		return sumMax;

	}
	
    public int maxProfit02(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0; 
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
	

}

