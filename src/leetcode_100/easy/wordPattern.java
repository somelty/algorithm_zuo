package leetcode_100.easy;

import java.util.*;
public class wordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if(pattern.length() != words.length) return false;
		Map<Object, Integer> map = new HashMap<Object, Integer>();
		for(int i = 0; i < pattern.length(); i++) {
			if(map.put(pattern.charAt(i), i)!= map.put(words[i], i)) {
				return false;
			}
		}
		return true;
		
	}
	
	/*
	 * map.put(pattern.charAt(i), i)
	 * 把模式串 pattern 的第 i 个字符作为 key，存入 map，并返回该 key 之前的值
	 * （如果之前没有，返回 null）
	 * */
}
