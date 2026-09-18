package leetcode_100.Easy;

// 移除元素
// https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
public class RemoveEle002 {

	// 快慢指针 O(n)遍历该序列至多两次    O(1)
	public int removeElement(int[] nums, int val) {
        int l = 0, r = 0;
        while (r < nums.length) {
        	if (nums[r] != val) {
        		nums[l++] = nums[r++];
        	} else {
        		r++;
        	}
        }
        return l + 1;
    }
	
	// 指针优化：首尾指针 O(n) 至多遍历该序列一次 O(1)
	// 边界问题：这里使用左闭右闭while里写l <= r
	// 若为左闭右开（此时r初始化为nums.lenght）写 l < r
	public int removeElement2(int[] nums, int val) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			if(nums[l] == val) {
				nums[l] = nums[r--]; // 可能有r位置也是val的情况，所以 l 不++
			} else {
				l++;
			}
		}
		return l;
	}
}
