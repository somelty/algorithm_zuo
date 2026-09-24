package leetcode_100.easy;

public class LongestCommonPrefix {
	class Solution1 {
		public static String longestCommonPrefix(String[] strs) {
	        if(strs == null || strs.length == 0) {
	        	return "";
	        }
	        String prefix = strs[0];
	        for(int i = 1; i < strs.length; i ++) {
	        	prefix = getCommonPrefix(prefix, strs[i]);
	        	if (prefix.length() == 0)break;
	        }
	        return prefix;
	    }
		
		public static String getCommonPrefix(String a, String b) {
			int minLen = Math.min(a.length(), b.length());
			int i = 0;
			while(i < minLen && a.charAt(i) == b.charAt(i)) {
				i++;
			}
			return a.substring(0, i);
		}
	}
	
	class Solution2{
		public static String longestCommonPrefix(String[] strs) {
			if (strs == null || strs.length == 0) return "";
			int count = strs.length;
			int len = strs[0].length();
			for(int i = 0; i < len; i++) {
				char c = strs[0].charAt(i);
				for (int j = 1; j < count; j ++) {
					if (i == strs[j].length() || strs[j].charAt(i) != c) {
						return strs[0].substring(0, i);
					}
				}
			}
			return strs[0];
		}
	}
	
	class Solution3{
		// 二分查找；
		// 时间复杂度 O(mnlogm)，二分查找的核心思路是：在 [0, 最短字符串长度] 范围内二分"公共前缀长度"，每次用 isCommonPrefix(mid) 验证，因此迭代次数是 O(log m)，每次验证又需要 O(m×n) 的比较，总复杂度为 O(mn log m)。
		// 二分查找只在字符串极长时可能有微弱优势——此时 log m 很小（例如长度 1000+ 的字符串只需约 10 次长度判断），可以减少无效对比。
		// 但对 LeetCode 这类题目（数组和字符串长度均不超过 200），二分查找反而实际可能更慢，因为代码更复杂且引入了额外的辅助函数开销。
	}
}
