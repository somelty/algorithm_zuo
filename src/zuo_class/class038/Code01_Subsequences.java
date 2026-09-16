package zuo_class.class038;

import java.util.HashSet;
import java.util.Set;

//字符串的全部子序列
//子序列本身是可以有重复的，只是这个题目要求去重
//测试链接 : https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
public class Code01_Subsequences {

	public static String[] generatePermutation(String str ) {
		HashSet<String> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		char[] s = str.toCharArray();
		f(s, 0, sb, set);
		int len = set.size();
		String[] ans = new String[len];
		int i = 0;
		for (String cur: set) {
			ans[i++] = cur;
		}
		return ans;
	}
	
	public static void f(char[] s, int i, StringBuilder path, Set<String> set) {
		if (s.length == i) {
			set.add(path.toString());
		} else {
			path.append(s[i]);
			f(s, i + 1, path, set);
			path.deleteCharAt(path.length() - 1);
			f(s, i + 1, path, set);
		}
	}
	
	public static String[] generatePermutation2(String str) {
		HashSet<String> set = new HashSet<>();
		char[] s = str.toCharArray();
		int len = s.length;
		char[] path = new char[len];
		f2(s, 0, path, 0, set);
		String[] ans = new String[set.size()];
		int i = 0;
		for (String cur: set) {
			ans[i++] = cur;
		}
		return ans;
	}
	
	public static void f2(char[] s, int i, char[] path, int size, HashSet<String> set) {
		if (i == s.length) {
			set.add(String.valueOf(path, 0, size));
			//set.add(path.toString()); 数组在 Java 里是对象，数组没有重写 toString ()，调用的是 Object 原生 toString：Object.toString() → 类型@哈希值
			return;
		} else {
			path[size] = s[i];
			f2(s, i + 1, path, size + 1, set);
			f2(s, i + 1, path, size, set);
		}
	}
}
