package zuo_class.class039;

//含有嵌套的字符串解码
//测试链接 : https://leetcode.cn/problems/decode-string/
public class Code02_DecodeString {
	
	public static int where;
	
	public static String decodeString(String str) {
		where = 0;
		return f(str.toCharArray(), 0);
	}
	
	public static String f(char[] s, int i) {
		int cur = 0;
		StringBuilder sb = new StringBuilder();
		while(i < s.length && s[i] != ']')	{
			if (s[i] >= 'a' && s[i] <= 'z' || s[i] >= 'A' && s[i] <= 'Z') {
				sb.append(s[i++]);
			} else if(s[i] != '[') { // 数字
				cur = cur * 10 + s[i++] - '0'; // 这里写错为 +=
			} else { // '['
				sb.append(get(cur, f(s, i + 1)));
				cur = 0;
				i = where + 1;
			}
		}
		where = i;
		return sb.toString();
	}
	
	public static String get(int cnt, String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cnt; i++) {
			sb.append(s);
		}
		return sb.toString();
	}
	
}
