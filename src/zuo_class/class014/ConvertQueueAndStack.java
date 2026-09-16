package zuo_class.class014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertQueueAndStack {
    // 用栈实现队列
    public static class MyQueue {
        /* 实现思路：
        * 使用两个栈，一个in，一个out，这样就可颠倒元素出去顺序
        * */
        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }
        /*
        从 in 栈倒入 out 栈，out 空了才能到数据，如果到数据，in 必须倒完
         */
        private void inToOut() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }

        // 模拟队列从末尾添加元素
        public void push(int x) {
            in.push(x);
            inToOut();
        }
        // 队列头部出队
        public int pop() {
            inToOut();
            return out.pop();
        }
        // 查看队首不删除
        public int peek() {
            inToOut();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    // 用队列实现栈
    public static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue.offer(x);
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

