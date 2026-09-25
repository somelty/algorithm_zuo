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

}
