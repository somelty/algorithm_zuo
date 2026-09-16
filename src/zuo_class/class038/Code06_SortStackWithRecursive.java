package zuo_class.class038;

import java.util.*;
//用递归函数排序栈
//栈只提供push、pop、isEmpty三个方法
//请完成无序栈的排序，要求排完序之后，从栈顶到栈底从小到大
//只能使用栈提供的push、pop、isEmpty三个方法、以及递归函数
//除此之外不能使用任何的容器，数组也不行
//就是排序过程中只能用：
//1) 栈提供的push、pop、isEmpty三个方法
//2) 递归函数，并且返回值最多为单个整数
public class Code06_SortStackWithRecursive {
	
	public static int deep(Stack<Integer> stack) {
		if (stack.isEmpty()) return 0;
		int cur = stack.pop();
		int d = deep(stack);
		stack.push(cur);
		return d + 1;
	}
	
	public static int max(Stack<Integer> stack, int deep) {
		if (deep == 0) return Integer.MIN_VALUE;
		int cur = stack.pop();
		int last = max(stack, deep - 1);
		int max = Math.max(last, cur);
		stack.push(cur);
		return max;
	}
	
	public static int times(Stack<Integer> stack, int deep, int max) {
		if (deep == 0) return 0;
		int cur = stack.pop();
		int last_time = times(stack, deep - 1, max);
		int time = last_time + (cur == max ? 1: 0); // 注意运算优先级
		stack.push(cur);
		return time;
	}
	
	public static void down(Stack<Integer> stack, int deep, int max, int times) {
		if (deep == 0) {
			for (int i = 0; i < times; i++) {
				stack.push(max);
			}
			return;
		}	
		int cur = stack.pop();
		down(stack, deep - 1, max, times);
		if (cur != max) {
			stack.push(cur);
			
		}
	}
	
	public static void sort(Stack<Integer> stack) {
		int d = deep(stack);
		while(d != 0) {
			int max = max(stack, d);
			int t = times(stack, d, max);
			down(stack, d, max, t);
			d -= t;
		}
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		test.add(1);
		test.add(5);
		test.add(4);
		test.add(5);
		test.add(3);
		test.add(2);
		test.add(3);
		test.add(1);
		test.add(4);
		test.add(2);
		sort(test);
		while (!test.isEmpty()) {
			System.out.println(test.pop());
		}
	}

}
