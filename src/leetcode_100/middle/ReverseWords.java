package leetcode_100.middle;

import java.util.*;

public class ReverseWords {
	
	class Solution1{
		// 使用 API
		public String reverseWords(String s) {
	        // split
			List<String> wordList = Arrays.asList(s.split("\\s+"));
			Collections.reverse(wordList);
			return String.join(" ", wordList); // join() 两个重载方法
			// 可以是数组，也可以是继承iterator的可迭代元素
	    }
	}
	
	// 对于反转的api：
	// 集合：Collections.reverse(list) 原地
	// 字符串反转： StringBuilder.reverse() 原地
	// 数组反转：手写双指针
	
	class Solution2{
		
		public static String reverseWords(String s) {
			if(s == null || s.length() == 0) return "";
			StringBuilder sb = trimSpaces(s);
			reverse(sb, 0, sb.length() -1);
			reverseEachWord(sb);
			return sb.toString();
		}
		
		
		public static StringBuilder trimSpaces(String s) {
			// 去除首尾空格
			int l = 0, r = s.length() - 1;
			while(l <= r && s.charAt(l) == ' ') l++;
			while(l <= r && s.charAt(r) == ' ') r--;
			StringBuilder sb = new StringBuilder();
			while(l <= r) {
				if(s.charAt(l) != ' ') sb.append(s.charAt(l));
				else if(sb.charAt(sb.length() - 1) != ' ') {// 报错，当sb刚开始没有添加时，len为0
					sb.append(s.charAt(l));
				}
				l++;
			} 
			return sb;
		}
		
		public static void reverse(StringBuilder sb, int left, int right) {
			while(left < right) {
				char temp = sb.charAt(left);
				sb.setCharAt(left++, sb.charAt(right));
				sb.setCharAt(right--, temp);
			}
		}
		
		public static void reverseEachWord(StringBuilder sb) {
			int l = 0, r = 0;
			int n = sb.length();
			while(l < n) {
				while(r < n && sb.charAt(r) != ' ') {
					r++;
				}
				reverse(sb, l, r - 1);
				l = r + 1;
				r++;
			}
		}
	}

}
