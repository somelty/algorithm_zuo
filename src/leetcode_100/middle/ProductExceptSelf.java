package leetcode_100.middle;

public class ProductExceptSelf {

	// 暴力 O(n^2)  超时
	public int[] productExceptSelf(int[] nums) {
		int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	ans[i] = 1;
        	for (int j = 0; j < nums.length; j++) {
        		if (j == i) continue;
        		ans[i] *= nums[j];
        	}
        }
        return ans;
    }
	
	// 双指针：很妙！！！
	// 虽然在同一个 while 循环里面，同时维护左右指针，每个数组元素会被读取两次，但是循环只跑 n 轮。大 O 时间复杂度依旧是 O (n)。对比分开写两个 for 循环（一共 2n 轮），它减少了循环的轮次，但是时间复杂度量级不变。
	public int[] productExceptSelf2(int[] nums) {
		int lp = 1, rp = 1;
        int l = 0, r = nums.length - 1;
        int[] ans = new int[nums.length];
        // 初始化全部为1
        for(int i=0;i<nums.length;i++) ans[i]=1;

        while(l < nums.length && r >= 0) {
            ans[l] *= lp; // = 会覆盖
            ans[r] *= rp;
            // 以上两行可以想象当l和r走在同一个位置时（长度奇数），中间位置刚好为lp * rp
            // 也就是该位置数字 左边累积 * 右边累积
            lp *= nums[l++]; // 先乘当前nums[l]，l再+1
            rp *= nums[r--]; // 先乘当前nums[r]，r再-1
        }
        return ans;
	}
	
	
	// 和双指针相同思路的写法也可以这么写：
	public int[] productExceptSelf3(int[] nums) {
		int[] ans = new int[nums.length];
		
		ans[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			ans[i] = nums[i - 1] * ans[i - 1]; 
			// nums[i-1] i 的前一个位置数字
			// ans[i-1]  i 的前一个位置数字的累积（不包括该位置即i-1位置）
		}
		
		int rp = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			ans[i] *= rp;
			rp *= nums[i];
		}
		return ans;
	}
	
	
}
