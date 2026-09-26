package leetcode_100.easy;

public class StrStr {
	
	public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
		for(int i = 0; i + n <= m; i ++) { // i + n < m 边界是错的
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if(haystack.charAt(i + j) != needle.charAt(j)) {
					flag = false;
					break;
				}
			}
			if(flag) return i;
		}
		return -1;
    }
	
	public int strStr2(String haystack, String needle) {
		// kmp算法
		// 初始工作
		int m = needle.length();
		int n = haystack.length();
		if (m == 0) return 0;
		int[] next = new int[m];
		// next[] 数组
		for(int j = 1, i = 0; j < n; j++) {
			// 不相等
			while(i > 0 && needle.charAt(i) != needle.charAt(j)) {
				i = next[i - 1];
			}
			// 相等
			if (needle.charAt(i) == needle.charAt(j)) {
				i++;
			}
			next[j] = i;
			// 赋值
		}
		
		for(int i = 0, j = 0; i < n; i++) {
			while(j > 0 && haystack.charAt(i) != needle.charAt(j)) {
				j = next[j - 1]; 
				// 当前位置不匹配，从当前之前的位置的前缀的最后一位的后一位开始和haystack的下一位匹配
			}
			if(haystack.charAt(i) == needle.charAt(j)) {
				j++;
			}
			if (j == m) {
				return i - m + 1;
			}
		}
		return -1;
	}

}
