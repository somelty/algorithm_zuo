package zuo_class.class011;

import zuo_class.class010.addTwoNumbers;

public class MergeTwoLists {
    public static void main(String[] args) {
        // 要求升序
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode head1 = new ListNode(0);
        ListNode node11 = new ListNode(2);
        ListNode node22 = new ListNode(5);
        ListNode node33 = new ListNode(7);
        head1.next = node11;
        node11.next = node22;
        node22.next = node33;
        node33.next = null;

        ListNode ans1 = mergeTwoLists2(head, head1);
        ans1.printList();

        ListNode ans = mergeTwoLists(head, head1);
        ans.printList();
    }

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

        public void printList() {
            // 打印所有节点
            ListNode cur = this;
            while (cur != null) {
                System.out.print(cur.val + " ");
                cur = cur.next;
            }
        }
    }

    public static ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return h1 == null ? h2: h1;
        }

        ListNode dummy = new  ListNode(-1);
        ListNode cur = dummy;

        // 核心逻辑
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        cur.next = h1 ==  null ? h2 : h1;
        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return h1 == null ? h2: h1;
        }

        ListNode head = h1.val < h2.val ? h1 : h2;
        ListNode cur = head; // 尾指针：插尾法
        ListNode cur1 = head.next;
        ListNode cur2 = head == h1 ? h2 : h1;

        while (cur1 != null && cur2 != null) {
            if ( cur1.val <= cur2.val) {
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }

        cur.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
