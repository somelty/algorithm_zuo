package leetcode_100.hard;

import java.util.Deque;
import java.util.LinkedList;
public class Trap {
	
	// 法一：单调栈：因为题目相当于求第一个比他大的元素，用单调递增栈
	public int trap(int[] height) {
		int ans = 0;
		Deque<Integer> stack = new LinkedList<>(); 
		int n = height.length;
		for (int i = 0; i < n; i++) {
			// 对于每个i
			// 如果top > height[i]:height[i] 出栈
			// top <= height[i]:height[i] 入栈
			// 如果只有两个柱子。。。   right         middle
			while(!stack.isEmpty() && height[i] > stack.peek()) {
				int middle = stack.pop();  // middle
				// 为防止只有或者最后只剩下两个柱子,没有左挡板
				if (stack.isEmpty()) break;
				int left = stack.peek();  
				int w = i - left - 1;
				int h = Math.min(height[i], height[left]) - height[middle];
				ans += (w * h);
			}
			stack.push(i);
		}
		return ans;
    } 
}
