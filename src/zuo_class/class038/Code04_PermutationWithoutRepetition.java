package zuo_class.class038;

import java.util.*;

//有重复项数组的去重全排列
//测试链接 : https://leetcode.cn/problems/permutations-ii/
public class Code04_PermutationWithoutRepetition {

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		f(nums, 0, ans);
		return ans;
	}
	
	public static void f(int[] nums, int i, List<List<Integer>> ans) {
		if (nums.length == i) {
			ArrayList<Integer> curs = new ArrayList<>();
			for (Integer cur: nums) {
				curs.add(cur);
			}
			ans.add(curs);
		} else {
			HashSet<Integer> set = new HashSet<>();
			for (int j = i; j < nums.length; j++) {
				if (!set.contains(nums[j])) {
					set.add(nums[j]);
					swap(nums, i, j);
					f(nums, i + 1, ans);
					swap(nums, i, j);
				
				}
			}
		}
	}
	
	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
