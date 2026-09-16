package zuo_class.class038;

import java.util.*;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的组合
//答案 不能 包含重复的组合。返回的答案中，组合可以按 任意顺序 排列
//注意其实要求返回的不是子集，因为子集一定是不包含相同元素的，要返回的其实是不重复的组合
//比如输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//测试链接 : https://leetcode.cn/problems/subsets-ii/
public class Code02_Combinations {
	/*
	 * 思路一：
	 * 双指针 + set 去重
	 * 思路二：
	 * 递归
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }
	
	public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
		if (i == nums.length) {
			ArrayList<Integer> curs = new ArrayList<>();
			for(Integer cur: path) {
				curs.add(cur);
			}
			ans.add(curs);
			return;
		} else {
			int j = i + 1;
			while(nums[j] == nums[i]) {
				j ++;
			}
			f(nums, j, path, size, ans);
			for (;i < j; i++) {
				path[size] = nums[i];
				f(nums, j, path, ++size, ans);
			}
		}
	}
	
}
/*
 * for (;i < j; i++) {
				path[size] = nums[i];
				f(nums, j, path, ++size, ans);
			}
			
			写法等价于：
	for (;i < j; i++) {
				path[size++] = nums[i];
				f(nums, j, path, size, ans);
			}
			
			但注意不等于：
	for (;i < j; i++) {
				path[size] = nums[i];
				f(nums, j, path, size + 1, ans);
			}
*/
