package zuo_class.class016;

import java.util.Deque;

public class CircularDeque {

    static class MyCircularDeque1 {

        public Deque<Integer> deque1;
        public int size;
        public int limit;

        public MyCircularDeque1(int k) {
            size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            deque1.offerFirst(value);
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            deque1.offerLast(value);
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            deque1.pollFirst();
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            deque1.pollLast();
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return deque1.peekFirst();
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return deque1.peekLast();
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

    static class MyCircularDeque2 {
        public int[] deque;
        public int size, limit, l, r;

        public MyCircularDeque2(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                // 插入首，移动l，l需要--，所以需要判断0位置
                l = l == 0 ? (limit - 1) : l - 1;
                deque[l] = value;
            }
            size++;
            return true;
        }
        public boolean insertLast(int value) {
            if (isFull()) return false;
            if (isEmpty()) {
                l = r = 0;
                deque[0] = value;
            } else {
                // 插入尾，移动r，r需要++，所以需要判断limit - 1位置
                r = r == limit - 1? 0: r + 1;
                deque[r] = value;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            // 删除首，移动l，l需要++，所以需要判断limit - 1位置，防止越界
            l = l == (limit - 1) ? 0: l + 1;
            size--;
            return true;
        }
        public boolean deleteLast() {
            if (isEmpty()) return false;
            r = r == 0? (limit - 1): r - 1;
            size--;
            return true;
        }
        public int getFront() {
            if (isEmpty()) return -1;
            return deque[l];
        }
        public int getRear() {
            if (isEmpty()) return -1;
            return deque[r];
        }
        public boolean isFull() {
            return size == limit;
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }
}
