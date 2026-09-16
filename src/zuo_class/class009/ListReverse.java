package zuo_class.class009;

import java.util.List;

public class ListReverse {
    public static void main(String[] args) {
        // byte long short char int string boolean float 都是按值传递
        int a = 10;
        f(a);
        System.out.println(a); // 10

        // 其他类型按引用传递
        // 比如下面的Number是自定义的类
        Number b = new Number(5);
        g1(b);
        System.out.println(b.val); // 5
        g2(b);
        System.out.println(b.val); // 6

        // 比如下面的一维数组
        int[] c = { 1, 2, 3, 4 };
        g3(c);
        System.out.println(c[0]); // 1
        g4(c);
        System.out.println(c[0]); // 100

        System.out.println();

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = reverseList(head);
        System.out.println(res);

        ListNode res2 = reverseList1(null, head);
        System.out.println(res2);

        DoubleListNode head1 = new DoubleListNode(1);
        DoubleListNode dNode1 = new DoubleListNode(2);
        DoubleListNode dNode2 = new DoubleListNode(3);
        DoubleListNode dNode3 = new DoubleListNode(4);
        DoubleListNode dNode4 = new DoubleListNode(5);
        head1.next = dNode1;
        dNode1.next = dNode2;
        dNode2.next = dNode3;
        dNode3.next = dNode4;
        dNode4.next = null;
        head1.pre = null;
        dNode1.pre = head1;
        dNode2.pre = dNode1;
        dNode3.pre = dNode2;
        dNode4.pre = dNode3;
        DoubleListNode dRes = reverseDoubleList(head1);
        System.out.println(dRes);

        DoubleListNode dRes2 = reverseDoubleList1(null, head1);
        System.out.println(dRes2);

    }

    public static void f(int a) {
        a = 0;
    }

    public static class Number {
        public int val;

        public Number(int v) {
            val = v;
        }
    }

    public static void g1(Number b) {
        b = null;
    }

    public static void g2(Number b) {
        b.val = 6;
    }

    public static void g3(int[] c) {
        c = null;
    }

    public static void g4(int[] c) {
        c[0] = 100;
    }


    // 单链表节点
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static class DoubleListNode {
        int val;
        DoubleListNode next;
        DoubleListNode pre;
        public DoubleListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }



    // 反转单列表，需要返回头节点
    // while 写法
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curl = head;

        while (curl != null) {
            ListNode temp = curl.next;
            curl.next = pre;
            pre = curl;
            curl = temp;
        }

        return pre;
    }

    // 递归写法
    public static ListNode reverseList1(ListNode pre, ListNode curl) {
        if (curl == null) {
            return pre;
        }
        ListNode temp = curl.next;
        curl.next = pre;

        return reverseList1(curl, temp);
    }

    // 双链表反转
    public static DoubleListNode reverseDoubleList(DoubleListNode head) {
         DoubleListNode pre = null;
         DoubleListNode curl = head;

         while (curl != null) {
             DoubleListNode temp = curl.next;
             curl.pre = curl.next;
             curl.next = pre;
             pre = curl;
             curl = temp;
         }

         return pre;
    }

    // 双链表递归反转
    public static DoubleListNode reverseDoubleList1(DoubleListNode pre, DoubleListNode curl) {
        if (curl == null) {
            return pre;
        }

        DoubleListNode temp = curl.next;
        curl.pre = curl.next;
        curl.next = pre;

        return reverseDoubleList1(curl, temp);
    }



}
