package zuo_class.class039;

import java.util.*;
//含有嵌套的表达式求值
//力扣上本题为会员题，所以额外提供了牛客网的测试链接
//如果在牛客网上提交，请将函数名从calculate改为solve
//测试链接 : https://leetcode.cn/problems/basic-calculator-iii/
//测试链接 : https://www.nowcoder.com/practice/c215ba61c8b1443b996351df929dc4d4
public class Code01_BasicCalculatorIII {
	
	public static int where;
	
	public static int calculate(String str) {
		// 调用函数f
		where = 0;
		return f(str.toCharArray(), 0);
	}
	
	public static int f(char[] s, int i) {
		// 处理（），遇到"（"进入f(),")"退出f()
		int cur = 0;
		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<Character> ops = new ArrayList<>();
		while(i < s.length && s[i] != ')') {
			if (s[i] <= '9' && s[i] >= '0') {
				cur = cur * 10 + s[i++] - '0';
			} else if(s[i] != '(') { // 运算符
				push(nums, ops, cur, s[i++]);
				cur = 0;
			} else { // 遇到 "("
				cur = f(s, i + 1);
				i = where + 1;
			}
		}
		where = i;
		push(nums, ops, cur, '+');
		return compute(nums, ops);
	}
	
	public static void push(ArrayList<Integer> nums, ArrayList<Character> ops, int cur, char op ) {
		// 处理+-*/，将其数字与符号入栈，同时处理*/
		int n = nums.size();
		if (n == 0 || ops.get(n - 1) == '+' || ops.get(n - 1) == '-') {
			nums.add(cur);
			ops.add(op);
		} else {
			int topNum = nums.get(n - 1);
			if (ops.get(n - 1) == '/') {
				nums.set(n - 1, topNum / cur);
			} else {
				nums.set(n - 1, topNum * cur);
			}
			ops.set(n - 1, op);
		}
	}
	
	public static int compute(ArrayList<Integer> nums, ArrayList<Character> ops) {
		// 根据数字与符号栈计算，最后的收尾方法
		int n = nums.size();
		int sum = nums.get(0);
		for (int i = 1; i < n; i++) {
			sum += ops.get(i - 1) == '+' ? nums.get(i) : -nums.get(i);
		}
		return sum;
	}
}
