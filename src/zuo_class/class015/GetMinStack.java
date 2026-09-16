package zuo_class.class015;

import java.util.Stack;

public class GetMinStack {
    class MinStack1 {
        public Stack<Integer> data;
        public Stack<Integer> min;

        public MinStack1() {
            data = new Stack<Integer>();
            min = new Stack<Integer>();
        }
        public void push(int val) {
            data.push(val);
            if (min.isEmpty() || val <= min.peek()) {
                min.push(val);
            } else {
                min.push(min.peek());
            }
        }

        public void pop() {
            data.pop();
            min.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    static class MinStack2 {
        public final int MAXN = 8001;

        public int[] data;
        public int[] min;
        int size;

        public MinStack2() {
            data = new int[MAXN];
            min = new int[MAXN];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            if (size == 0 || val <= min[size - 1]){
                min[size] = val;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }
    }
}
