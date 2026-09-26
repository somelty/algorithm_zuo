package leetcode_100.easy;

public class IsPalindrome {

	public boolean isPalindrome(String s) {
		// 新开一个String[] 数组，且两遍遍历，开销大
		if(s == null || s.length() == 0) return true;
        String str = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int l = 0, r = str.length() - 1;
        while(l < r) {
        	if(str.charAt(l) != str.charAt(r)) {
        		return false;
        	}
        	l++;
        	r--;
        }
        return true;
    }
	
	// 原地双指针法
	public boolean isPalindrome2(String s) {
		if(s == null || s.length() == 0) return true;
		int l = 0, r = s.length() - 1;
        while(l < r) {
        	
        	// 两个while都是l < r，如果写为 l<s.length() or r>0 就需要在if里加l<r这个条件
        	while(l < r && !Character.isLetterOrDigit(s.charAt(l)))l++;
        	while(l < r && !Character.isLetterOrDigit(s.charAt(r)))r--;
        	if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
        	l++;
        	r--;
        }
        return true;
    }
}
