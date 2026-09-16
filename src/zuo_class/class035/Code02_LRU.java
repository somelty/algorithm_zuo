package zuo_class.class035;

import java.util.HashMap;

// 实现 LRU 结构
// 测试链接 : https://leetcode.cn/problems/lru-cache/
public class Code02_LRU {
    class LRUCache {
        private final int capacity;
        private HashMap<Integer, DoubleNode> keyNodeMap;
        private DoubleList nodeList;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keyNodeMap = new HashMap<>();
            nodeList = new DoubleList();
        }

        public void put(int k, int v) {
            if (keyNodeMap.containsKey(k)) {
                DoubleNode node = keyNodeMap.get(k);
                node.val = v;
                nodeList.moveNodeToTail(node);
            } else {
                if (keyNodeMap.size() == capacity) {
                    keyNodeMap.remove(nodeList.removeHead().key);
                }
                DoubleNode doubleNode = new DoubleNode(k, v);
                keyNodeMap.put(k, doubleNode);
                nodeList.addNode(doubleNode);
            }
        }

        public int get(int k) {
            if (!keyNodeMap.containsKey(k)) {
                return -1;
            }
            DoubleNode doubleNode = keyNodeMap.get(k);
            nodeList.moveNodeToTail(doubleNode);
            return doubleNode.val;
        }

        class DoubleNode {
            public int key;
            public int val;
            public DoubleNode last;
            public DoubleNode next;

            public DoubleNode(int k, int v) {
                key = k;
                val = v;
            }
        }

        class DoubleList {
            private DoubleNode head;
            private DoubleNode tail;

            public DoubleList() {
                head = null;
                tail = null;
            }

            public void addNode(DoubleNode newNode) {
                if (newNode == null) {
                    return;
                }
                if (head == null) {
                    head = tail = newNode;
                } else {
                    tail.next = newNode;
                    newNode.last = tail;
                    tail = newNode;
                }

            }
            public void moveNodeToTail(DoubleNode node) {
                if (tail == node) {
                    return;
                }
                if (head == node) { // 这里代表 tail != node, head == node, 相当于链表长度 >= 2
                    head = node.next;
                    head.last = null;
                } else {
                    node.last.next = node.next;
                    node.next.last = node.last;
                }
                node.next = null;
                node.last = tail;
                tail.next = node;
                tail = node;
            }
            public DoubleNode removeHead() {  // 返回删除的头节点（最早操作的节点）
                if (head == null) return null;
                DoubleNode ans = head;
                if (head == tail) {
                    head = tail = null;
                } else {
                    head = ans.next;
                    ans.next = null;
                    head.last = null;
                }
                return ans;
            }

        }
    }
}
