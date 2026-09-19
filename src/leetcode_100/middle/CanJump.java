package leetcode_100.middle;

public class CanJump {
	
	// 贪心
	public boolean canJump(int[] nums) {
       
		int n = nums.length;
		int rmax = 0;
		for (int i = 0; i < n; i++) {
			if (rmax >= i) {
				rmax = Math.max(rmax, i + nums[i]);
				if (rmax >= n-1)return true;
			}
		}
		return false;
    }

}
