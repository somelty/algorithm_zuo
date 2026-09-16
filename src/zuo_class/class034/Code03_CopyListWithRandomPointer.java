package zuo_class.class034;

// 复制带随机指针的链表
// 测试链接 : https://leetcode.cn/problems/copy-list-with-random-pointer/
public class Code03_CopyListWithRandomPointer {
    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int v) {
            val = v;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        // 第一次遍历，串联新老节点
        Node temp = null;
        Node cur = head;
        while(cur != null){
            temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }

        // 第二次遍历，为每一个新节点设置 random 指针
        cur = head;
        Node copy = null;
        while(cur != null){
            copy = cur.next;
            copy.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }

        // 第三次遍历，分离新老链表
        Node ans = head.next;
        cur = head;
        while(cur != null){
            temp = cur.next.next;
            copy = cur.next;
            cur.next = temp;
            copy.next = temp != null ? temp.next : null;
            cur = temp;
        }

        return ans;
    }
}
