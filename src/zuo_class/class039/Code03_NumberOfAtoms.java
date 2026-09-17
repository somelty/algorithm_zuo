package zuo_class.class039;

import java.util.*;
//含有嵌套的分子式求原子数量
//测试链接 : https://leetcode.cn/problems/number-of-atoms/
public class Code03_NumberOfAtoms {

	public static int where;

    public static String countOfAtoms(String formula) {
        where = 0;
        TreeMap<String, Integer> map = f(formula.toCharArray(), 0);
        StringBuilder sb = new StringBuilder();
        for(String key: map.keySet()) {
        	sb.append(key);
        	int cnt = map.get(key);
        	if (cnt > 1) {
        		sb.append(cnt);
        	}
        }
        return sb.toString();
    }
    
    public static TreeMap<String, Integer> f(char[] s, int i) {
    	TreeMap<String, Integer> ans = new TreeMap<>();
    	TreeMap<String, Integer> pre = new TreeMap<>();
    	StringBuilder sb = new StringBuilder();
    	int cur = 0;
    	while(i < s.length && s[i] != ')') {
    		if(s[i] >= 'A' && s[i] <= 'Z' || s[i] == '(') {
    			full(ans, pre, sb, cur);
    			cur = 0;
    			pre = null;
    			sb.setLength(0); // 写sb = null;会报错：NullPointerException（空指针异常）
    			if (s[i] >= 'A' && s[i] <= 'Z') {
    				sb.append(s[i++]);
    			} else {
    				pre = f(s, i+1); // 把下一层的ans赋值给这一层的pre
    				i = where + 1;
    			}
    		} else if(s[i] >= '0' && s[i] <= '9') {
    			cur = cur * 10 + s[i++] - '0';
    		} else { // 小写字母
    			sb.append(s[i++]);
    		}
    	}
    	full(ans, pre, sb, cur);
    	where = i;
    	return ans;
    }
    
    public static void full(TreeMap<String, Integer> ans, TreeMap<String, Integer> pre, StringBuilder s, int cnt) {
    	if (s.length() > 0 || pre != null) {
    		cnt = cnt == 0 ? 1: cnt;
    		if (s.length() > 0) {
    			String key = s.toString();
    			ans.put(key, ans.getOrDefault(key, 0) + cnt);
    		} else {
    			for (String key : pre.keySet()) {
    				ans.put(key, ans.getOrDefault(key, 0) + pre.get(key) * cnt);
    			}
    		}
    	}
    }
    
	
}
