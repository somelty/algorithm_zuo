package leetcode_100.easy;

// 移除有序数组中的重复项
// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
// 数组有序，返回长度<= 原数组长度，可以考虑双指针
public class RemoveDuplicates003 {
	
	 public static int solution(int[] nums) {
		 if(nums.length == 0) return 0;
		 int l = 0, r = 1;
		 
		 for(; r < nums.length; r++) {
			 if(nums[r] != nums[l]) {
        		l ++;
        		nums[l] = nums[r];
        	}
        }
        return l + 1;
	 }

}
