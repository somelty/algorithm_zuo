package zuo_class.class038;

import java.util.*;
//用递归函数逆序栈
public class Code05_ReverseStackWithRecursive {

	public static void reverse(Stack<Integer> stack) {
		 if (stack.isEmpty())return;
		 int last = bottomOut(stack);
		 reverse(stack);
		 stack.push(last);
	}
	
	public static int bottomOut(Stack<Integer> stack) {
		int ans = stack.pop();
		if (stack.isEmpty()) return ans;
		int last = bottomOut(stack);
		stack.push(ans);
		return last;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		/*while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}*/
		reverse(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
