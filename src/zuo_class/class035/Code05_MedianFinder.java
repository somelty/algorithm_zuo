package zuo_class.class035;

import java.util.PriorityQueue;

// 快速获得数据流的中位数的结构
// 测试链接 : https://leetcode.cn/problems/find-median-from-data-stream/
public class Code05_MedianFinder {
    class MedianFinder {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>((a, b) -> a - b);
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (minHeap.isEmpty() || (minHeap.peek() <= num)) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
            balance();
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }

        private void balance() {
            /**
             * 这里条件判断错误，原本想maxHeap与minHeap的差值大于等于2就调整堆
            if (maxHeap.size() - minHeap.size() >= 2) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }*/
            if (Math.abs(maxHeap.size() - minHeap.size()) == 2) {
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                } else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }
    }
}
