package leetcode_100.easy;
import java.util.*;

public class MajorityElement {
	
	// 法一：分治法 时间O(n * logn) 每层合并代价为 n，logn 层，空间O(logn)递归栈
	class fz{
		
		private int countInRange(int[] nums, int num, int lo, int hi) {
			int count = 0;
			for (int i = lo; i <= hi; i++) {
				if (nums[i] == num) {
					count++;
				}
			}
			return count;
		}
		
		private int majorityElementRec(int[] nums, int s, int e) {
			
			if (s == e)return nums[s];
			
			int mid = (int)(s + (e - s) / 2);
			int leftMax = majorityElementRec(nums, s, mid);
			int rightMax = majorityElementRec(nums, mid+1, e);
			
			if(leftMax == rightMax) {
				return leftMax;
			}
			
			int lc = countInRange(nums, leftMax, s, e);
			int rc = countInRange(nums, rightMax, s, e);
			
			return lc >= rc? leftMax: rightMax;
			
		}
		
		public int majorityElement(int[] nums) {
	        return majorityElementRec(nums, 0, nums.length - 1);
	    }

	}
	
	class hashMethod{
		private Map<Integer, Integer> countNums(int[] nums){
			Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
			for (int num: nums) {
				counts.put(num, counts.getOrDefault(num, 0) + 1);
			}
			return counts;
		}
		
		public int majorityElement(int[] nums) {
			Map<Integer, Integer> counts = countNums(nums);
			
			Map.Entry<Integer, Integer> entry = null; // 成员/全局变量默认自动初始化，局部变量不会，但可以编译通过，但读取时会报未初始化
			for (Map.Entry<Integer, Integer> e: counts.entrySet()) {
				if(entry == null || entry.getValue() < e.getValue()) {
					entry = e;
				}
			}
			return entry.getKey();
		}
		
	}
	
	class BoyerMoore{
		
		public int majorityElement(int[] nums) {
			int count = 0;
			int num = 0;
			for (int n: nums) {
				if (n == num) {
					count++;
				} else {
					if (count != 0) count--;
					else {
						num = n;
						count++;
					}
				}
			}
			
			return num;
		}
	}
	
	class RandomMethod{
		
		private int randRange(Random rand, int min, int max) {
			// rand.nextInt(n) 生成的是：[0, n)
			return rand.nextInt(max - min) + min;
		}
		
		private int countOccurences(int[] nums, int num) {
	        int count = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (nums[i] == num) {
	                count++;
	            }
	        }
	        return count;
	    }
		
		public int majorityElement(int[] nums) {
			Random r = new Random();
			int count = nums.length / 2;
			while(true) {
				int idx = randRange(r, 0, nums.length);
				int curCount = countOccurences(nums, nums[idx]);
				if (curCount > count) return nums[idx];
			}
			
		}
	}
	
	class SortMethod{
		public int majorityElement(int[] nums) {
			Arrays.sort(nums);
			return nums[nums.length / 2];
		}
	}
	

}
