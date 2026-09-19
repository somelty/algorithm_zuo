package leetcode_100.middle;

// 贪心
public class MinJumpSteps {

	// 法一：反向查找  最坏O(n^2)
	public int jump(int[] nums) {
        int position = nums.length - 1;
        int step = 0;
        
        while(position > 0) { // 注意边界不等于0
        	// 因为position等于0表示以及可以到0位置，若while=0会再进循环，step多了1
        	for(int i = 0; i <= position; i++) {
        		if (i + nums[i] >= position) {
        			step++;
        			position = i;
        		}
        	}	
        }
        return step;
        
    }
	
	// 法二：正向查找  O(n)
	/**
	 * 维护两个变量：当前一跳可以到达的最远位置cur，当前位置覆盖范围内下一步跳到的最大位置next
	 * @param nums
	 * @return
	 */
	public int jump2(int[] nums) {
		
		int next = 0;
		int cur = 0;
		int steps = 0;
		for(int i = 0; i < nums.length-1; i++) {
			next = Math.max(next, i + nums[i]);
			if (i == cur) { // 当前一跳走到极限，再跳一次
				steps++;
				cur = next;
					
			}
		}
		return steps;
	}
}
