package zuo_class.class038;

import java.util.*;

//没有重复项数字的全排列
//测试链接 : https://leetcode.cn/problems/permutations/
public class Code03_Permutations {
	
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		f(nums, 0, ans);
		return ans;
	}
	
	public static void f(int[] nums, int idx, List<List<Integer>> ans) {
		if (nums.length == idx) {
			ArrayList<Integer> curs = new ArrayList<>();
			for (Integer cur: nums) {
				curs.add(cur);
			}
			ans.add(curs);
		} else {
			for (int j = idx; j < nums.length; j++) {
				swap(nums, idx, j);
				f(nums, idx + 1, ans);
				swap(nums, idx, j);
			}
		}
	}
	
	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}

/** O(n * n!) n! 种结果（递归树第一层n，第二层每个节点有n-1个分支，以此类推...），每种结果收集为 n
*/