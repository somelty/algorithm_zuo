package zuo_class.class013;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStackAndCircularQueue {
       public static class Queue1 {
           public Queue<Integer> queue = new LinkedList<Integer>();

           // 调用任何方法之前，先调用这个方法来判断队列内是否有东西
           public boolean isEmpty() {
               return queue.isEmpty();
           }
           public int size() {
               return queue.size();
           }
           // 返回队列头元素但是不弹出
           public int peek() {
               return queue.peek();
           }
           // 从队列头拿
           public int poll() {
               return queue.poll();
           }
           // 队列尾加入num
           public void offer(int value) {
               queue.offer(value);
           }
       }

       public static class Queue2 {
           public int[] queue;
           public int l, r;

           public Queue2(int n) { // 加入操作次数上限
               queue = new int[n];
               l = 0;
               r = 0;
           }
           public boolean isEmpty() {
                return r == l;
           }
           public void offer(int value) {
               queue[r++] = value;
           }
           public int poll() {
                return queue[l++];
           }
           public int size() {
               return r - l;
           }
           public int tail() {
                return queue[r - 1];
           }
           public int head() {
                return queue[l];
           }
       }

       // 直接用Java自带的，底层动态数组实现，常数时间不好
       public static class stack1 {
           public Stack<Integer> stack = new Stack<Integer>();
           public boolean isEmpty() {
               return stack.isEmpty();
           }
           public int size() {
               return stack.size();
           }
           public int peek() {
               return stack.peek();
           }
           public int pop() {
               return stack.pop();
           }
           public void push(int value) {
               stack.push(value);
           }
       }

       public static class Stack2 {
           public int[] stack;
           public int size;

           public Stack2(int n) {
               stack = new int[n];
               size = 0;
           }

           public boolean isEmpty() {
               return size == 0;
           }
           public int size() {
               return size;
           }
           public int peek() {// 返回最后一个元素
               return stack[size - 1];
           }
           public void push(int value) {
               stack[size++] = value;
           }
           public int pop() {
               return stack[--size];
           }
       }

       // 循环队列
       public static class CircularQueue {
           public int[] queue;
           public int size, l, r, limit;// size：数组目前使用长度

           public CircularQueue(int n) {
               queue = new int[n];
               limit = n;
               l = r = size = 0;
           }

           public boolean isEmpty() {
               return size == 0;
           }

           public boolean isFull() {
               return size == limit;
           }

           // 返回队列的最后一个数字，不弹出
           public int Rear() {
                if (isEmpty()) return 0;
                int last = r == 0 ? limit - 1: (r - 1);
                return queue[last];
           }

           // 返回队列头部的数字（不弹出），如果没有数返回-1
           public int Front() {
               if (isEmpty()) return -1;
               return queue[l];
           }

           // 入队
           public boolean enQueue(int value) {
               if (isFull()) return false;
               queue[r] = value;
               r = (r + 1) % limit;
               size++;
               return true;
           }
           // 出队
           public boolean deQueue() {
               if (isEmpty()) return false;
               l = (l + 1) % limit;
               size--;
               return true;
           }
       }
}
